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
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    private static User user = UserFactory.build("12313","12","25","Test","Test","email","2523452");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/User";

    @Test
    void a_create() {
        String url = BASE_URL +"/create";
        ResponseEntity<User> postResponse=restTemplate.postForEntity(url, user ,User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        user =postResponse.getBody();
        System.out.println("Saved data: "+ user);
        assertEquals(user.getUserId(),postResponse.getBody().getUserId());
    }

    @Test
    void b_read() {
        String url= BASE_URL +"/read/"+ user.getUserId();
        System.out.println("URL: "+url);
        ResponseEntity<User> response=restTemplate.getForEntity(url,User.class);
        assertEquals(user.getUserId(),response.getBody().getUserId());
    }

    @Test
    void c_update(){
        User updated=new User.userBuilder().copy(user).setFirstName("Tests").build();
        String url= BASE_URL +"/update";
        System.out.println("URL: "+url);
        System.out.println("Post data: "+updated);
        ResponseEntity<User> response=restTemplate.postForEntity(url,updated,User.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url= BASE_URL +"/delete/"+ user.getUserId();
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
