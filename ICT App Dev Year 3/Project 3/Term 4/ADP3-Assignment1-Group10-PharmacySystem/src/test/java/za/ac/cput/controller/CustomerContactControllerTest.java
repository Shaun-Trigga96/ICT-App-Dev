/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactControllerTest.java
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.factory.CustomerContactFactory;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerContactControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CustomerContactController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private CustomerContact customerContact;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        this.customerContact = CustomerContactFactory.createCustomerContact("01","0213552233", "Pharmacy@gmail.com");
        this.baseUrl = "http://localhost:" + this.port + "/PharmacySystem/customerContact/";
    }

    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<CustomerContact> response = this.restTemplate
                .postForEntity(url, this.customerContact, CustomerContact.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.customerContact.getCustomerId();
        System.out.println(url);
        ResponseEntity<CustomerContact>response=
                this.restTemplate.getForEntity(url,CustomerContact.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.customerContact.getCustomerId();
        System.out.println(url);
        this.restTemplate.delete(url,controller.delete(url));
    }

    @Order(3)
    @Test
    void findAll() {

        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<CustomerContact[]>response=
                this.restTemplate.getForEntity(url,CustomerContact[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()->assertTrue(response.getBody().length==1)
        );
    }
}