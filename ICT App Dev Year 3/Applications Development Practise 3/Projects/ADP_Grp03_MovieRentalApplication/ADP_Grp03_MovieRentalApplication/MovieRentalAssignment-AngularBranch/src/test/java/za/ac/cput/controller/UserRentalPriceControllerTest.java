package za.ac.cput.controller;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.junit.jupiter.api.Disabled;
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
import za.ac.cput.entity.UserRental;
import za.ac.cput.entity.UserRentalPrice;
import za.ac.cput.factory.UserRentalPriceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRentalPriceControllerTest {

    private static UserRentalPrice userRentalPrice = UserRentalPriceFactory.build(10,20.00);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/UserRentalPrice";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<UserRentalPrice> postResponse=restTemplate.postForEntity(url, userRentalPrice, UserRentalPrice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        userRentalPrice =postResponse.getBody();
        System.out.println("Saved data: "+ userRentalPrice);
        assertEquals(userRentalPrice.getRentalId(),postResponse.getBody().getRentalId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ userRentalPrice.getRentalId();
        System.out.println("URL: "+url);
        ResponseEntity<UserRentalPrice> response=restTemplate.getForEntity(url, UserRentalPrice.class);
        assertEquals(userRentalPrice.getRentalId(),response.getBody().getRentalId());
    }

    @Test
    void c_update() {
        UserRentalPrice updated = new UserRentalPrice.UserRentalPriceBuilder().copy(userRentalPrice).setDuration(15).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        ResponseEntity<UserRentalPrice> response = restTemplate.postForEntity(url,updated,UserRentalPrice.class);
    }

    @Test
    @Disabled
    void e_delete(){
        String url= BASE_URL +"/delete"+ userRentalPrice.getRentalId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url= BASE_URL +"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}