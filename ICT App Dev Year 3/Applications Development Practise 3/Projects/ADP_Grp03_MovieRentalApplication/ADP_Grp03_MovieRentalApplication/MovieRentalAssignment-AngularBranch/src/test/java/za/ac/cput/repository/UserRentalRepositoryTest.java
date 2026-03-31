package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.UserRental;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.factory.UserRentalFactory;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserRentalRepositoryTest {
    private static UserRentalRepository repository = UserRentalRepository.getRepository();
    private static UserRental userRental = UserRentalFactory.build("15","156");

    @Test
    void a_create() {
        UserRental created = repository.create(userRental);
        assertEquals(created.toString(), userRental.toString());
        System.out.println(("Create: " + created));
    }

    @Test
    void b_read() {
        UserRental read = repository.read(userRental.getRentalId());

        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        UserRental updated = new UserRental.UserRentalBuilder().copy(userRental).setUserId("15").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(userRental.getRentalId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(repository.getAll());
    }
}