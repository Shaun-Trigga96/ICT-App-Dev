package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Studio;
import za.ac.cput.factory.StudioFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudioControllerTest {
    private static Studio studio = StudioFactory.build("1234", "Sony");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/studio";


    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Studio> postResponse = restTemplate.postForEntity(url, studio, Studio.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        studio = postResponse.getBody();
        System.out.println("Data Saved: " + studio);
        assertEquals(studio.getStudioId(), postResponse.getBody().getStudioId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + studio.getStudioId();
        System.out.println("URL: " + url);
        ResponseEntity<Studio> response = restTemplate.getForEntity(url, Studio.class);
        //studio = response.getBody();
        assertNotNull(studio.getStudioId(), response.getBody().getStudioId());
        System.out.println(studio);
    }

    @Test
    void c_update() {
        Studio update = new Studio.Builder().copy(studio).setStudioName("Marvel").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated to : " + update);
        ResponseEntity<Studio> response = restTemplate.postForEntity(url, update, Studio.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete" + studio.getStudioId();
        System.out.println("URl: " + url);
        restTemplate.delete(url);

    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Data: ");
        System.out.println(response);
        System.out.println(response.getStatusCode());

    }
}