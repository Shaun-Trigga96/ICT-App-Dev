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

import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {
    private static Role role = RoleFactory.build("123","TEst","HI");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/Role";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<Role> postResponse=restTemplate.postForEntity(url, role,Role.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        role =postResponse.getBody();
        System.out.println("Saved data: "+ role);
        assertEquals(role.getRoleId(),postResponse.getBody().getRoleId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read/"+ role.getRoleId();
        System.out.println("URL: "+url);
        ResponseEntity<Role> response=restTemplate.getForEntity(url,Role.class);
        assertEquals(role.getRoleId(),response.getBody().getRoleId());
    }

    @Test
    void c_update(){
        Role updated=new Role.roleBuilder().copy(role).setName("Yaasins").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<Role> response=restTemplate.postForEntity(url,updated,Role.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ role.getRoleId();
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
