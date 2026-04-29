package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    @Autowired
    EmployeeService empService;

    private final Employee employee1 = EmployeeFactory.createEmployee("001", "male", "Zaeem", "","Petersen" );
    private final Employee employee2 = EmployeeFactory.createEmployee("002", "male", "Waseem", "","Dollie" );

    @Order(1)
    @Test
    void save() {
        Employee create1 = empService.save(this.employee1);
        Employee create2 = empService.save(this.employee2);
        assertNotNull(create1);
        assertNotNull(create2);
        System.out.println(create1);
        System.out.println(create2);
    }

    @Order(2)
    @Test
    void read() {
     Employee read1 = empService.read(employee1.getStaffId());
     Employee read2 = empService.read(employee2.getStaffId());

     assertEquals(read1.getStaffId(), employee1.getStaffId());
     System.out.println(read1);

     assertEquals(read2.getStaffId(), employee2.getStaffId());
     System.out.println(read2);
    }

    @Order(4)
    @Test
    void delete() {
        boolean success = empService.delete(employee1.getStaffId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(empService.getAll());
    }
}