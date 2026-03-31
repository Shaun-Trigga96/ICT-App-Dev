package za.ac.cput.controller.previousQualification;

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
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.factory.previousQualification.SubjectFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectControllerTest {



    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/subject/";

    private static Subject subject = SubjectFactory.createSubject("Multimedia", 52);

    @Test
    public void a_create() {
        //Subject subject = SubjectFactory.createSubject("MAF123", 52);
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.println("Post data" + subject);

        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(url, subject, Subject.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        subject = postResponse.getBody();
        System.out.println("Saved data: " + subject);
        assertEquals(subject.getSubjectId(), postResponse.getBody().getSubjectId());

        // System.out.println(postResponse);
        //
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        //   System.out.println("URL" + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + subject.getSubjectId();
        System.out.println("URL" + url);

        ResponseEntity<Subject> response = restTemplate.getForEntity(url, Subject.class);
        assertEquals(subject.getSubjectId(), response.getBody().getSubjectId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update(){
        Subject updated = new Subject.Builder().copy(subject).setSubjectName("Multimedia").build();
        String url = baseURL + "update";
        System.out.println("URL " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Subject> response = restTemplate.postForEntity(url, updated, Subject.class);
        assertEquals(subject.getSubjectId(), response.getBody().getSubjectId());


    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/" + subject.getSubjectId();
        System.out.println("URL " + url);
        restTemplate.delete(url);

    }
}