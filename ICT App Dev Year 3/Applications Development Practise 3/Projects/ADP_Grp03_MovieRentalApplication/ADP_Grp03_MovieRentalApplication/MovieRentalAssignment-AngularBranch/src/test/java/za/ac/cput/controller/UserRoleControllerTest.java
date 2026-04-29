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
import za.ac.cput.entity.userRole;
import za.ac.cput.factory.UserRoleFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRoleControllerTest {
    private static userRole userrole = UserRoleFactory.build("589",12);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/UserRole";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<userRole> postResponse=restTemplate.postForEntity(url, userrole ,userRole.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        userrole =postResponse.getBody();
        System.out.println("Saved data: "+ userrole);
        assertEquals(userrole.getUserId(),postResponse.getBody().getUserId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read/"+ userrole.getUserId();
        System.out.println("URL: "+url);
        ResponseEntity<userRole> response=restTemplate.getForEntity(url,userRole.class);
        assertEquals(userrole.getUserId(),response.getBody().getUserId());
    }

    @Test
    void c_update(){
        userRole updated=new userRole.userRoleBuilder().copy(userrole).setRoleId(123).build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<userRole> response=restTemplate.postForEntity(url,updated,userRole.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ userrole.getUserId();
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
