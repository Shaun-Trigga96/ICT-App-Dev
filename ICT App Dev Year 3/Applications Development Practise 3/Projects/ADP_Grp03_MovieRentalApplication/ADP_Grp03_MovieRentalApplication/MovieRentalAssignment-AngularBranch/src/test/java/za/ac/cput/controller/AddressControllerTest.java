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
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {
    private static Address address = AddressFactory.build("Blenheim","Test","test","test",0111,"586");

    public String SECURITY_USERNAME ="user";
    public String SECURITY_PASSWORD ="password";
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/Address";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Address> postResponse=restTemplate.postForEntity(url, address,Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        address =postResponse.getBody();
        System.out.println("Saved data: "+ address);
        assertEquals(address.getUserId(),postResponse.getBody().getUserId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read"+ address.getUserId();
        System.out.println("URL: "+url);
        ResponseEntity<Address> response=restTemplate.getForEntity(url,Address.class);
        assertEquals(address.getUserId(),response.getBody().getUserId());
    }

    @Test
    void c_update(){
        Address updated=new Address.addressBuilder().copy(address).setStreet("Cape").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Address> response=restTemplate.postForEntity(url,updated,Address.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ address.getUserId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url= BASE_URL +"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response= restTemplate
                .withBasicAuth(SECURITY_USERNAME , SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
