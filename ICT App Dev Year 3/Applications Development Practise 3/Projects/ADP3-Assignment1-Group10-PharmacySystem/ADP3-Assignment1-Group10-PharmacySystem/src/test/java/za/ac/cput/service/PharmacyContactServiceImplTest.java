package za.ac.cput.service;

/* Pharmacy.java
Service for the PharmacyContact
Author: Waseem Dollie (216040566)
Date: 115 October 2022 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.PharmacyContactFactory;
import za.ac.cput.factory.PharmacyFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PharmacyContactServiceImplTest {

    @Autowired
    PharmacyContactService pharmacyContactService;

    private final PharmacyContact pharmacyContact = PharmacyContactFactory.build("123","0208348302","216040566@mycput.ac.za");

    @Order(1)
    @Test
    void save() {
        PharmacyContact create1 = pharmacyContactService.save(this.pharmacyContact);
        assertNotNull(create1);
        System.out.println(create1);
    }

    @Order(2)
    @Test
    void read() {
        PharmacyContact read1 = pharmacyContactService.read(pharmacyContact.getPharmId());

        assertEquals(read1.getPharmId(), pharmacyContact.getPharmId());
        System.out.println(read1);

    }

    @Order(4)
    @Test
    void delete() {
        boolean success = pharmacyContactService.delete(pharmacyContact.getPharmId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(pharmacyContactService.getAll());
    }
}
