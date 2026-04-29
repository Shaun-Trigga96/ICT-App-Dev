/*SupplierServiceImplTest.java
 * Test Service class for Supplier
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceImplTest {
    @Autowired
    SupplierServiceImpl supplierService;

    private static Supplier supplier = SupplierFactory.createSupplier("7","ChemReact");


    @Test
    @Order(1)
    void save() {
        Supplier capturedSupplier = supplierService.save(this.supplier);
        assertNotNull(capturedSupplier);
        System.out.println(capturedSupplier);
    }

    @Test
    @Order(2)
    void read() {
        Supplier readSupplier = supplierService.read(supplier.getSuppId());
        assertEquals(readSupplier.getSuppId(), supplier.getSuppId());
        System.out.println(readSupplier);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = supplierService.delete(supplier.getSuppId());
        assertTrue(success);
        System.out.println("ID " + supplier.getSuppId() +" has been deleted");
    }

    @Test
    @Order(3)
    void getAll() {
        System.out.println(supplierService.getAll());
    }
}