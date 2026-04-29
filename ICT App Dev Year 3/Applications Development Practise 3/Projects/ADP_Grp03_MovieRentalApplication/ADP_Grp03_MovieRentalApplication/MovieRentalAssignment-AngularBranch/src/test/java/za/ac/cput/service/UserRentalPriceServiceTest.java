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
import za.ac.cput.entity.UserRentalPrice;
import za.ac.cput.factory.UserRentalPriceFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserRentalPriceServiceTest {

    @Autowired
    private UserRentalPriceService service;

    private static UserRentalPrice userRentalPrice = UserRentalPriceFactory.build(12,25.00);

    @Test
    void a_create() {
        UserRentalPrice created = service.create(userRentalPrice);
        assertEquals(created.toString(),userRentalPrice.toString());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        UserRentalPrice read = service.read(userRentalPrice.getRentalId());
        assertEquals(read.toString(), userRentalPrice.toString());
        System.out.println("Create: " + read);
    }

    @Test
    void c_update() {
        UserRentalPrice updated = new UserRentalPrice.UserRentalPriceBuilder().copy(userRentalPrice).setDuration(9).build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}