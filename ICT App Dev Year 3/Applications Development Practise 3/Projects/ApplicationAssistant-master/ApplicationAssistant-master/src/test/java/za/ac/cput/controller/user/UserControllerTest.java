package za.ac.cput.controller.user;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.entity.user.User;
import za.ac.cput.factory.user.UserFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/user/";

    private static User user = UserFactory.createUser("Abdullah", "abdllahryklief@gmail.com", "password", "abdullahryklief@gmail.com", "password");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + user);

        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        user = postResponse.getBody();
        System.out.println("Saved Data: " + user);
        assertEquals(user.getUserId(), postResponse.getBody().getUserId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + user.getUserId();
        System.out.println("URL: " + url);

        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setUserEmail("abdullahryklief@gmail.com").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, updated, User.class);
        assertEquals(user.getUserId(), postResponse.getBody().getUserId());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}