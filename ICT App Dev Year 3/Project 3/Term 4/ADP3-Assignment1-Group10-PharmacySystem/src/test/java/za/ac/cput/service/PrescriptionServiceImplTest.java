package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Prescription;
import za.ac.cput.factory.PrescriptionFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PrescriptionServiceImplTest {

    private static Prescription prescription1 = PrescriptionFactory.createPrescription("01", "pain reliever", "4");

    private static Prescription prescription2 = PrescriptionFactory.createPrescription("02", "stimulants", "2");

    @Autowired
    private PrescriptionService prescService;

    @Order(1)
    @Test
    void save() {
        Prescription create1 = prescService.save(this.prescription1);
        Prescription create2 = prescService.save(this.prescription2);
        assertNotNull(create1);
        assertNotNull(create2);
        System.out.println(create1);
        System.out.println(create2);
    }

    @Order(2)
    @Test
    void read() {
        Prescription read1 = prescService.read(prescription1.getPrescID());
        Prescription read2 = prescService.read(prescription2.getPrescID());

        assertEquals(read1.getPrescID(),prescription1.getPrescID());
        System.out.println(read1);

        assertEquals(read2.getPrescID(),prescription2.getPrescID());
        System.out.println(read2);
    }

    @Order(4)
    @Test
    void delete() {
        boolean success = prescService.delete(prescription1.getPrescID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Order(3)
    @Test
    void getAll() {
        System.out.println(prescService.getAll());
    }
}