package za.ac.cput.controller.tertiaryInstitution;

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
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/faculty/";

    private static Faculty faculty = FacultyFactory.createFaculty("ICT123", "Informatics and Design");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + faculty);

        ResponseEntity<Faculty> postResponse = restTemplate.postForEntity(url, faculty, Faculty.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        faculty = postResponse.getBody();
        System.out.println("Saved Data: " + faculty);
        assertEquals(faculty.getFacultyId(), postResponse.getBody().getFacultyId());
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
        String url = baseURL + "read/" + faculty.getFacultyId();
        System.out.println("URL: " + url);

        ResponseEntity<Faculty> response = restTemplate.getForEntity(url, Faculty.class);
        assertEquals(faculty.getFacultyId(), response.getBody().getFacultyId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Faculty updated = new Faculty.Builder().copy(faculty).setFacultyName("Informatics and Design").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Faculty> postResponse = restTemplate.postForEntity(url, updated, Faculty.class);
        assertEquals(faculty.getFacultyId(), postResponse.getBody().getFacultyId());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + faculty.getFacultyId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}
