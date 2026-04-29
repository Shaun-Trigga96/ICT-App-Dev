package za.ac.cput.controller;

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
import za.ac.cput.entity.Rating;
import za.ac.cput.factory.RatingFactory;
/*
    RatingControllerTest.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
*/
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RatingControllerTest {
    private static Rating rating = RatingFactory.build(3);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/rating";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Rating> postResponse=restTemplate.postForEntity(url,rating,Rating.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        rating=postResponse.getBody();
        System.out.println("Saved data: "+rating);
        assertEquals(rating.getMovieId(),postResponse.getBody().getMovieId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+rating.getMovieId();
        System.out.println("URL: "+url);
        ResponseEntity<Rating> response=restTemplate.getForEntity(url,Rating.class);
        assertEquals(rating.getMovieId(),response.getBody().getMovieId());
    }

    @Test
    void c_update(){
        Rating updated=new Rating.RatingBuilder().copy(rating).setRating(3).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Rating> response=restTemplate.postForEntity(url,updated,Rating.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+rating.getMovieId();
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