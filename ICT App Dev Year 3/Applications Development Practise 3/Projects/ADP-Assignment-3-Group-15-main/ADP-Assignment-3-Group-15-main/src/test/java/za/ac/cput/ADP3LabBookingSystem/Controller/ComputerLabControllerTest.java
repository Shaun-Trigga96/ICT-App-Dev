/*
 * ComputerLabControllerTest.java
 * ComputerLabController test class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComputerLabControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8090/computerlab";


    private final String username = "admin";
    private final String password = "admin1234";

    private static ComputerLab computerLab = ComputerLabFactory.createComputerLab("3.14", "30000", 120, true);

    @Test
    void a_create() {
        String url = baseURL + "/create";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        ResponseEntity<ComputerLab> postResponse = testRestTemplate.postForEntity(url, computerLab, ComputerLab.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        computerLab = postResponse.getBody();
        System.out.println("Saved data: " + computerLab);
        assertEquals(computerLab.getLabId(), postResponse.getBody().getLabId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + computerLab.getLabId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        ResponseEntity<ComputerLab> responseEntity = testRestTemplate.getForEntity(url, ComputerLab.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(computerLab.getLabId(), responseEntity.getBody().getLabId());
    }

    @Test
    void c_update() {
        ComputerLab updatedComputerLab = new ComputerLab.Builder().copy(computerLab).setCapacity(80).build();

        String url = baseURL + "/update";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        ResponseEntity<ComputerLab> responseEntity = testRestTemplate.postForEntity(url, updatedComputerLab, ComputerLab.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + computerLab.getLabId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        ResponseEntity<ComputerLab> responseEntity = testRestTemplate.getForEntity(baseURL + "/read/" + computerLab.getLabId(), ComputerLab.class);
        assertNotNull(responseEntity.getBody().getLabId(), "Computer lab id{'" + computerLab.getLabId() + "'} was not found.");
        testRestTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Read all...");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }
}