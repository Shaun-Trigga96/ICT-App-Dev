package za.ac.cput.controller;
/*
    MovieControllerTest.java
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
import za.ac.cput.entity.Movie;
import za.ac.cput.factory.MovieFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerTest {
    private static Movie movie = MovieFactory.build("ADP","asf","weges","afasd","asd",56,12);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/movie";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Movie> postResponse=restTemplate.postForEntity(url, movie,Movie.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        movie =postResponse.getBody();
        System.out.println("Saved data: "+ movie);
        assertEquals(movie.getMovieId(),postResponse.getBody().getMovieId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ movie.getMovieId();
        System.out.println("URL: "+url);
        ResponseEntity<Movie> response=restTemplate.getForEntity(url,Movie.class);
        assertEquals(movie.getMovieId(),response.getBody().getMovieId());
    }

    @Test
    void c_update(){
        Movie updated=new Movie.MovieBuilder().copy(movie).setTitle("PRT").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Movie> response=restTemplate.postForEntity(url,updated,Movie.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ movie.getMovieId();
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