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
import za.ac.cput.factory.UserRentalFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRentalControllerTest {
    public static UserRental userRental = UserRentalFactory.build("8","91");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/UserRental";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<UserRental> postResponse=restTemplate.postForEntity(url, userRental, UserRental.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        userRental =postResponse.getBody();
        System.out.println("Saved data: "+ userRental);
        assertEquals(userRental.getRentalId(),postResponse.getBody().getRentalId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ userRental.getRentalId();
        System.out.println("URL: "+url);
        ResponseEntity<UserRental> response=restTemplate.getForEntity(url, UserRental.class);
        assertEquals(userRental.getRentalId(),response.getBody().getRentalId());
    }

    @Test
    void c_update() {
        UserRental updated=new UserRental.UserRentalBuilder().copy(userRental).setReturnDate("20 January 2018").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<UserRental> response=restTemplate.postForEntity(url,updated,UserRental.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete(){
        String url= BASE_URL +"/delete/"+ userRental.getRentalId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url= BASE_URL +"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}