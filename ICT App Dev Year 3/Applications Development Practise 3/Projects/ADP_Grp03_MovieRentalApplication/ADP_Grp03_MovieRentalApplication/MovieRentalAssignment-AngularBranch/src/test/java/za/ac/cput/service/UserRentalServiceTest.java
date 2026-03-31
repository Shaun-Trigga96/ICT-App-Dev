package za.ac.cput.service;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.UserRental;
import za.ac.cput.factory.UserRentalFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserRentalServiceTest {

    @Autowired
    private UserRentalService service;

    private static UserRental userRental = UserRentalFactory.build("9", "32");

    @Test
    void a_create() {
        UserRental created = service.create(userRental);
        assertEquals(created.toString(), userRental.toString());
        System.out.println(("Create: " + created));
    }

    @Test
    void b_read() {
        UserRental read = service.read(userRental.getRentalId());

        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        UserRental updated = new UserRental.UserRentalBuilder().copy(userRental).setUserId("11").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}