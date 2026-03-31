package za.ac.cput.service;

/* PharmacyServiceImplTest.java
ServiceImplTest for the Pharmacy
Author: Waseem Dollie (216040566)
Date: 14 October 2022 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.PharmacyFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PharmacyServiceImplTest {

    @Autowired
    PharmacyService pharmacyService;

    private final Pharmacy pharmacy = PharmacyFactory.build("123", "DolliePharm", "23", "33");

    @Order(1)
    @Test
    void save() {
        Pharmacy create1 = pharmacyService.save(this.pharmacy);
        assertNotNull(create1);
        System.out.println(create1);
    }

    @Order(2)
    @Test
    void read() {
        Pharmacy read1 = pharmacyService.read(pharmacy.getPharmId());

        assertEquals(read1.getPharmId(), pharmacy.getPharmId());
        System.out.println(read1);

    }

    @Order(4)
    @Test
    void delete() {
        boolean success = pharmacyService.delete(pharmacy.getPharmId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(pharmacyService.getAll());
    }
}
