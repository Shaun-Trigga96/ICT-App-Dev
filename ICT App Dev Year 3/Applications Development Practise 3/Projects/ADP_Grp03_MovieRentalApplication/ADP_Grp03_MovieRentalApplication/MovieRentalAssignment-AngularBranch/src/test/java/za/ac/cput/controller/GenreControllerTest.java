/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */
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
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.GenreFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenreControllerTest {
    private static Genre genre = GenreFactory.build("HOR","Horror","These horrors will give you sleepless nights and and scream like never before");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/movie";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Genre> postResponse=restTemplate.postForEntity(url, genre,Genre.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        genre =postResponse.getBody();
        System.out.println("Saved data: "+ genre);
        assertEquals(genre.getGenreId(),postResponse.getBody().getGenreId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + genre.getGenreId();
        System.out.println("URL: " + url);
        ResponseEntity<Genre> response = restTemplate.getForEntity(url, Genre.class);
        assertEquals(genre.getGenreId(), response.getBody().getGenreId());
    }

    @Test
    void c_update(){
        Genre updated=new Genre.genreBuilder().copy(genre).setGenreName("Action").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Genre> response= restTemplate.postForEntity(url,updated,Genre.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ genre.getGenreId();
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