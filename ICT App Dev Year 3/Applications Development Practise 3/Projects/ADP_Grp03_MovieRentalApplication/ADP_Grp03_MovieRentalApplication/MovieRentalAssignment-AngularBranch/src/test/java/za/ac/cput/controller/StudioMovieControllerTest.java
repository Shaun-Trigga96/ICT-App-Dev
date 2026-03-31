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
import za.ac.cput.entity.StudioMovie;
import za.ac.cput.factory.StudioMovieFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudioMovieControllerTest {
    private static StudioMovie studioMovie = StudioMovieFactory.build("2234", "1234");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/movie";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<StudioMovie> postResponse=restTemplate.postForEntity(url, studioMovie,StudioMovie.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        studioMovie =postResponse.getBody();
        System.out.println("Saved data: "+ studioMovie);
        assertEquals(studioMovie.getStudioId(),postResponse.getBody().getStudioId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + studioMovie.getStudioId();
        System.out.println("URL: " + url);
        ResponseEntity<StudioMovie> response = restTemplate.getForEntity(url, StudioMovie.class);
        assertEquals(studioMovie.getStudioId(), response.getBody().getStudioId());
    }

    @Test
    void c_update(){
        StudioMovie updated=new StudioMovie.studioBuilder().copy(studioMovie).setStudioId("6666").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<StudioMovie> response= restTemplate.postForEntity(url,updated,StudioMovie.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ studioMovie.getStudioId();
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