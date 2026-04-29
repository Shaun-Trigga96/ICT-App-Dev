package za.ac.cput.controller;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 *LK Comit
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
import za.ac.cput.entity.MovieRentedOut;
import za.ac.cput.factory.MoviesRentedOutFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MovieRentedOutControllerTest {
    public static MovieRentedOut movieRentedOut = MoviesRentedOutFactory.build("lk90yt",6);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/MovieRentedOut";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<MovieRentedOut> postResponse=restTemplate.postForEntity(url, movieRentedOut, MovieRentedOut.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        movieRentedOut =postResponse.getBody();
        System.out.println("Saved data: "+ movieRentedOut);
        assertEquals(movieRentedOut.getMovieID(),postResponse.getBody().getMovieID());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ movieRentedOut.getMovieID();
        System.out.println("URL: "+url);
        ResponseEntity<MovieRentedOut> response=restTemplate.getForEntity(url, MovieRentedOut.class);
        assertEquals(movieRentedOut.getMovieID(),response.getBody().getMovieID());
    }

    @Test
    void c_update() {
        MovieRentedOut updated=new MovieRentedOut.MovieRentedOutBuilder().copy(movieRentedOut).setQuantity(2).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<MovieRentedOut> response=restTemplate.postForEntity(url,updated,MovieRentedOut.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete(){
        String url= BASE_URL +"/delete/"+ movieRentedOut.getMovieID();
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
