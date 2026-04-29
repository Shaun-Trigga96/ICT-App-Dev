/*
 * CovidStatusControllerTest.java
 * Author: Grant Metcalf (217222943)
 * Date: October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;
import za.ac.cput.ADP3LabBookingSystem.Factory.CovidStatusFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CovidStatusControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/computerlab";

    private static CovidStatus covidStatus = CovidStatusFactory.createCovidStatus("217222943", 36, false);

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<CovidStatus> postResponse = testRestTemplate.postForEntity(url, covidStatus, CovidStatus.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        covidStatus = postResponse.getBody();
        System.out.println("Saved data: " + covidStatus);
        assertEquals(covidStatus.getStudentNumber(), postResponse.getBody().getStudentNumber());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + covidStatus.getStudentNumber();
        ResponseEntity<CovidStatus> responseEntity = testRestTemplate.getForEntity(url, CovidStatus.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(covidStatus.getStudentNumber(), responseEntity.getBody().getStudentNumber());
    }

    @Test
    void c_update() {
        CovidStatus updatedCovidStatus = new CovidStatus.Builder().copy(covidStatus).setSymptoms(true).build();

        String url = baseURL + "/update";
        ResponseEntity<CovidStatus> responseEntity = testRestTemplate.postForEntity(url, updatedCovidStatus, CovidStatus.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + covidStatus.getStudentNumber();
        ResponseEntity<CovidStatus> responseEntity = testRestTemplate.getForEntity(baseURL + "/read/" + covidStatus.getStudentNumber(), CovidStatus.class);
        assertNotNull(responseEntity.getBody().getStudentNumber(), "Student Number{'" + covidStatus.getStudentNumber() + "'} was not found.");
        testRestTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Read all...");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }
}