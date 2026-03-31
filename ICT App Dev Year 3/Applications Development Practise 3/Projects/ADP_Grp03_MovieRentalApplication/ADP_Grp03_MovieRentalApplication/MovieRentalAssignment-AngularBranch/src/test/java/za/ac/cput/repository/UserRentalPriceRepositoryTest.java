package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.UserRentalPrice;
import za.ac.cput.factory.UserRentalPriceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRentalPriceRepositoryTest {
    private static UserRentalPriceRepository repository = UserRentalPriceRepository.getRepository();
    private static UserRentalPrice userRentalPrice = UserRentalPriceFactory.build(5,10.00);

    @Test
    void a_create() {
        UserRentalPrice created = repository.create(userRentalPrice);
        assertEquals(created.toString(),userRentalPrice.toString());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        UserRentalPrice read = repository.read(userRentalPrice.getRentalId());
        assertEquals(read.toString(), userRentalPrice.toString());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        UserRentalPrice updated = new UserRentalPrice.UserRentalPriceBuilder().copy(userRentalPrice).setDuration(10).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(userRentalPrice.getRentalId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(repository.getAll());
    }
}