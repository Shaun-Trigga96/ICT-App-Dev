package za.ac.cput.controller;
/*
    StockControllerTest.java
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
import za.ac.cput.entity.Stock;
import za.ac.cput.factory.StockFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StockControllerTest {
    private static Stock stock = StockFactory.build(3);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/stock";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Stock> postResponse=restTemplate.postForEntity(url,stock,Stock.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        stock=postResponse.getBody();
        System.out.println("Saved data: "+stock);
        assertEquals(stock.getMovieId(),postResponse.getBody().getMovieId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+stock.getMovieId();
        System.out.println("URL: "+url);
        ResponseEntity<Stock> response=restTemplate.getForEntity(url,Stock.class);
        assertEquals(stock.getMovieId(),response.getBody().getMovieId());
    }

    @Test
    void c_update(){
        Stock updated=new Stock.StockBuilder().copy(stock).setQuantity(5).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Stock> response=restTemplate.postForEntity(url,updated,Stock.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+stock.getMovieId();
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