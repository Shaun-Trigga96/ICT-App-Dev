package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;
import za.ac.cput.ADP3LabBookingSystem.Factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AddressControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/address";

    private static Address address = AddressFactory.createAddress("12", "Cape town", "Zonnebloem", 7600);

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Address> postResponse = testRestTemplate.postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        address = postResponse.getBody();
        System.out.println("Saved data: " + address);
        assertEquals(address.getZipCode(), postResponse.getBody().getZipCode());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + address.getZipCode();
        ResponseEntity<Address> responseEntity = testRestTemplate.getForEntity(url, Address.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(address.getZipCode(), responseEntity.getBody().getZipCode());
    }

    @Test
    void c_update() {
        Address updatedAddress = new Address.Builder().copy(address).setZipCode(80).build();

        String url = baseURL + "/update";
        ResponseEntity<Address> responseEntity = testRestTemplate.postForEntity(url, updatedAddress, Address.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + address.getZipCode();
        ResponseEntity<Address> responseEntity = testRestTemplate.getForEntity(baseURL + "/read/" + address.getZipCode(), Address.class);
        assertNotNull(responseEntity.getBody().getZipCode(), "Address id{'" + address.getZipCode() + "'} was not found.");
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
