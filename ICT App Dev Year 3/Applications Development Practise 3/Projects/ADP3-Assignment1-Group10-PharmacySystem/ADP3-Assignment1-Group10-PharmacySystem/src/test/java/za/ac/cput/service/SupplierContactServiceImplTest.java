/*SupplierContactServiceImplTest.java
 * Test Service class for SupplierContact
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.SupplierContact;
import za.ac.cput.factory.SupplierContactFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierContactServiceImplTest {
    @Autowired
    SupplierContactServiceImpl supplierContactService;
    private static SupplierContact supplierContact = SupplierContactFactory
            .createSupplierContact("7","0846541234","219466424@mycput.ac.za");

    @Test
    @Order(1)
    void save() {
        SupplierContact capturedSupplierContact = supplierContactService.save(this.supplierContact);
        assertNotNull(capturedSupplierContact);
        System.out.println(capturedSupplierContact);
        }

    @Test
    @Order(2)
    void read() {
        SupplierContact readSupplierContact = supplierContactService.read(supplierContact.getSuppId());
        assertEquals(readSupplierContact.getSuppId(), supplierContact.getSuppId());
        System.out.println(readSupplierContact);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = supplierContactService.delete(supplierContact.getSuppId());
        assertTrue(success);
        System.out.println("ID " + supplierContact.getSuppId() +" has been deleted");
    }

    @Test
    @Order(3)
    void getAll() {
        System.out.println(supplierContactService.getAll());
    }
}