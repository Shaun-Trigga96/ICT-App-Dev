package za.ac.cput.controller;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 *lk
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
import za.ac.cput.entity.NumberOfMoviesRented;
import za.ac.cput.factory.NumberOfMoviesRentedFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class NumberOfMoviesRentedControllerTest {
    public static NumberOfMoviesRented numberOfMoviesRented = NumberOfMoviesRentedFactory.build(8,"Kj52L",98,11);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/NumberOfMoviesRented";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<NumberOfMoviesRented> postResponse=restTemplate.postForEntity(url, numberOfMoviesRented, NumberOfMoviesRented.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        numberOfMoviesRented =postResponse.getBody();
        System.out.println("Saved data: "+ numberOfMoviesRented);
        assertEquals(numberOfMoviesRented.getMovieID(),postResponse.getBody().getMovieID());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ numberOfMoviesRented.getMovieID();
        System.out.println("URL: "+url);
        ResponseEntity<NumberOfMoviesRented> response=restTemplate.getForEntity(url, NumberOfMoviesRented.class);
        assertEquals(numberOfMoviesRented.getMovieID(),response.getBody().getMovieID());
    }

    @Test
    void c_update() {
        NumberOfMoviesRented updated=new NumberOfMoviesRented.NumberOfMoviesRentedBuilder().copy(numberOfMoviesRented).setNumMovies(6).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<NumberOfMoviesRented> response=restTemplate.postForEntity(url,updated,NumberOfMoviesRented.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete(){
        String url= BASE_URL +"/delete/"+ numberOfMoviesRented.getMovieID();
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
