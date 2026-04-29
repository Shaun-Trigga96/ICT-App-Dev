/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * InventoryControllerTest.java
 */

package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/inventory";
    private String username = "siphosethu";
    private String password = "feni";

    private static Inventory inventory = InventoryFactory.createInventory(55, 99);

    @Test
    void a_save() {
        System.out.println("Initial Inventory: " + inventory);
        String url = BASE_URL + "/save";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<Inventory> entity = new HttpEntity<>(inventory, headers);
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, entity, Inventory.class, headers);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        inventory = postResponse.getBody();
        assertEquals("99", postResponse.getBody().getMedicineStockAmount());
        System.out.println("Created: " + postResponse.getBody());
    }

    @Test
    void b_find() {
        String url = BASE_URL + "/find/" + inventory.getInventoryID();
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<Inventory> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Inventory> response = restTemplate.exchange(url, HttpMethod.GET, entity, Inventory.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        Inventory update = new Inventory.Builder().copy(inventory).setMedicineStockAmount(22).build();
        String url = BASE_URL + "/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<Inventory> entity = new HttpEntity<>(update, headers);
        ResponseEntity<Inventory> response = restTemplate.exchange(url, HttpMethod.POST, entity, Inventory.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Updated: " + response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<Inventory> entity = new HttpEntity<>(inventory, headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, Boolean.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("Read: " + response.getBody());
    }

}