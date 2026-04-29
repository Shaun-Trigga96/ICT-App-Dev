/*MedicationServiceImplTest.java
 * Test Service class for Medication
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Medication;
import za.ac.cput.factory.MedicationFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicationServiceImplTest {
    @Autowired
    MedicationServiceImpl medicationService;

    private static final Medication medication = MedicationFactory.createMedication("2","Allergex" , "Adcock Ingram","7");

    @Test
    @Order(1)
    void save() {
        Medication capturedMedication = medicationService.save(this.medication);
        assertNotNull(capturedMedication);
        System.out.println(capturedMedication);
    }

    @Test
    @Order(2)
    void read() {
        Medication readMedication = medicationService.read(medication.getMedId());
        assertEquals(readMedication.getMedId(), medication.getMedId());
        System.out.println(readMedication);
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = medicationService.delete(medication.getMedId());
        assertTrue(success);
        System.out.println("ID " + medication.getMedId() +" has been deleted");
    }

    @Test
    @Order(3)
    void getAll() {
        System.out.println(medicationService.getAll());
    }
}