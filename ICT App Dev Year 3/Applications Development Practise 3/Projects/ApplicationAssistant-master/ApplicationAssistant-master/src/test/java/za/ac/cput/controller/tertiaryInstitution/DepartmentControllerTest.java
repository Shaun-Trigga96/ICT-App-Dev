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
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/department/";

    private static Department department = DepartmentFactory.createDepartment("Engineering", "ICT123");
    private static String SECURITY_USERNAME = "Abdullah";
    private static String SECURITY_PASSWORD = "password";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + department);

        ResponseEntity<Department> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, department, Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);


        department = postResponse.getBody();
        System.out.println("Saved Data: " + department);
        assertEquals(department.getDepartmentId(), postResponse.getBody().getDepartmentId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + "c9ac2c66-e00b-4fe3-86b1-d477e7e7523c";
        System.out.println("URL: " + url);

        ResponseEntity<Department> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Department.class);
       // assertEquals(department.getDepartmentId(), response.getBody().getDepartmentId());
        System.out.println(response.getBody());
    }

    @Test
    public void c_update() {
        Department updated = new Department.Builder().copy(department).setDepartmentName("Information Technology").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Department> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Department.class);
      //  assertEquals(department.getDepartmentId(), postResponse.getBody().getDepartmentId());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + department.getDepartmentId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}