package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import za.ac.cput.ADP3LabBookingSystem.Entity.Student;
import za.ac.cput.ADP3LabBookingSystem.Factory.StudentFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String baseUrl = "http://localhost:8090/student";
    private static Student student = StudentFactory.build("Faidh","Adams","Adams@gmail.com","0834746561");

    private String admin = "admin";
    private String adminPass = "admin1234";
    private String user = "lema";
    private String userPass = "lema1234";

    @Test
    void a_create(){

        String url = baseUrl + "/create";
        httpHeaders.setBasicAuth(admin,adminPass);
        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
        ResponseEntity<Student> responseEntity = testRestTemplate.exchange(url, HttpMethod.POST, httpEntity, Student.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        student = responseEntity.getBody();
        System.out.println("New Student: "+student);
        assertEquals(student.getStudentNumber(), responseEntity.getBody().getStudentNumber());
    }

    @Test
    void b_read() {

        String url = baseUrl + "/read/" + student.getStudentNumber();
        httpHeaders.setBasicAuth(user,userPass);
        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
        ResponseEntity<Student> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity, Student.class);
        assertNotNull(responseEntity);
        System.out.println("Read data: " + responseEntity.getBody());
        assertEquals(student.getStudentNumber(), responseEntity.getBody().getStudentNumber());

    }

    @Test
    void c_update() {

        Student updatedStudent = new Student.Builder().copy(student).setEmail("Meyers@gmail.com").build();
        String url = baseUrl + "/update";
        httpHeaders.setBasicAuth(admin,adminPass);
        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
        ResponseEntity<Student> responseEntity = testRestTemplate.postForEntity(url, updatedStudent, Student.class);
        assertNotNull(responseEntity);
        System.out.println("Updated data: " + responseEntity.getBody());
    }

    @Test
    void d_delete() {
        String url = baseUrl + "/delete/" + student.getStudentNumber();
        httpHeaders.setBasicAuth(admin,adminPass);
        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
        ResponseEntity<Boolean> responseEntity = testRestTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Boolean.class);
        assertTrue(responseEntity.getBody(), "Student Number {'" + student.getStudentNumber() + "'} was not found.");
        testRestTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = baseUrl + "/getall";
        httpHeaders.setBasicAuth(user,userPass);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<List<Student>> responseEntity = testRestTemplate.exchange(url, HttpMethod.GET, httpEntity,  new ParameterizedTypeReference<List<Student>>() {});
        System.out.println("Read all...");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }
}

