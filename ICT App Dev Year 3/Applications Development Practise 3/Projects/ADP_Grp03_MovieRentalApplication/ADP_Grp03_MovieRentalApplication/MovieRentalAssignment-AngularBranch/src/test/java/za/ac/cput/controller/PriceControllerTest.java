package za.ac.cput.controller;
/*
    PriceControllerTest.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Price;
import za.ac.cput.factory.PriceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {
    private static Price price = PriceFactory.build(3);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/price";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Price> postResponse=restTemplate.postForEntity(url, price,Price.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        price =postResponse.getBody();
        System.out.println("Saved data: "+ price);
        assertEquals(price.getMovieId(),postResponse.getBody().getMovieId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ price.getMovieId();
        System.out.println("URL: "+url);
        ResponseEntity<Price> response=restTemplate.getForEntity(url,Price.class);
        assertEquals(price.getMovieId(),response.getBody().getMovieId());
    }

    @Test
    void c_update(){
        Price updated=new Price.PriceBuilder().copy(price).setAmount(25).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Price> response=restTemplate.postForEntity(url,updated,Price.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ price.getMovieId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url= BASE_URL +"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}