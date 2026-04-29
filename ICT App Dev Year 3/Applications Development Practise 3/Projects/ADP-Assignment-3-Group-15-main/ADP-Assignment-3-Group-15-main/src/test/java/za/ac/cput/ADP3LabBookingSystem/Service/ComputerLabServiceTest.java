/*
 * ComputerLabServiceTest.java
 * ComputerLabService test class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Service;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ComputerLabServiceTest {

    @Autowired
    private ComputerLabService computerLabService;

    private static ComputerLab computerLab = ComputerLabFactory.createComputerLab("2.22","20001", 40, true);

    @Test
    void a_create() {
        ComputerLab createdComputerLab = computerLabService.create(computerLab);
        assertNotNull(createdComputerLab);
        System.out.println("Created...");
        System.out.println("Computer Lab: " + createdComputerLab);
    }

    @Test
    void b_read() {
        ComputerLab readComputerLab = computerLabService.read(computerLab.getLabId());
        assertNotNull(readComputerLab);
        System.out.println("Read...");
        System.out.println("Computer Lab: " + readComputerLab);
    }

    @Test
    void c_update() {
        ComputerLab oldComputerLab = computerLabService.read(computerLab.getLabId());
        ComputerLab updatedComputerLab = new ComputerLab.Builder().copy(oldComputerLab).setAvailability(false).build();
        assertNotNull(computerLabService.update(updatedComputerLab));
        System.out.println("Updated...");
        System.out.println("Computer Lab: " + updatedComputerLab);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean isDeleted = computerLabService.delete("1.29");
        assertTrue(isDeleted);
        System.out.println("Deleted: " + isDeleted);
    }

    @Test
    void d_getAll() {
        List<ComputerLab> computerLabList = computerLabService.getAll();
        computerLabList.forEach( computerLab -> System.out.println("Computer Lab: " + computerLab));
    }
}