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
import za.ac.cput.entity.MovieGenre;
import za.ac.cput.entity.Studio;
import za.ac.cput.factory.MovieGenreFactory;
import za.ac.cput.factory.StudioFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieGenreControllerTest {
    private static MovieGenre movieGenre = MovieGenreFactory.build("1234", "2211");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/moviegenre";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<MovieGenre> postResponse = restTemplate.postForEntity(url, movieGenre, MovieGenre.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        movieGenre = postResponse.getBody();
        System.out.println("Data Saved: " + movieGenre);
        assertEquals(movieGenre.getGenreId(), postResponse.getBody().getGenreId());
    }

    @Test
    void read() {String url = baseURL + "/read" + movieGenre.getGenreId();
        System.out.println("URL: " + url);
        ResponseEntity<MovieGenre> response = restTemplate.getForEntity(url, MovieGenre.class);
        //studio = response.getBody();
        assertNotNull(movieGenre.getGenreId(), response.getBody().getGenreId());
        System.out.println(movieGenre);

    }

    @Test
    void update() {
        MovieGenre update = new MovieGenre.Builder().copy(movieGenre).setGenreId("1222").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated to : " + update);
        ResponseEntity<MovieGenre> response = restTemplate.postForEntity(url, update, MovieGenre.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + movieGenre.getGenreId();
        System.out.println("URl: " + url);
        restTemplate.delete(url);

    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Data: ");
        System.out.println(response);
        System.out.println(response.getStatusCode());
    }
}