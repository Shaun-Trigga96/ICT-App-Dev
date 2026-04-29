package za.ac.cput.ADP3LabBookingSystem.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;
import za.ac.cput.ADP3LabBookingSystem.Factory.CovidStatusFactory;
/*
 * CovidStatusService.java
 * Author: Grant Metcalf (217222943)
 * Date: October 2021
 * */
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CovidStatusServiceTest {

   @Autowired
    private CovidStatusService covidStatusService;

    private static CovidStatus covidStatus = CovidStatusFactory.createCovidStatus("217222943",36.4,false);

    @Test
    void a_create() {
        CovidStatus createdCovidStatus = covidStatusService.create(covidStatus);
        assertNotNull(createdCovidStatus);
        System.out.println("Created...");
        System.out.println("CovidStatus: " + createdCovidStatus);
    }

    @Test
    void b_read() {
        CovidStatus readCovidStatus = covidStatusService.read(covidStatus.getStudentNumber());
        assertNotNull(readCovidStatus);
        System.out.println("Read...");
        System.out.println("CovidStatus: " + readCovidStatus);
    }

    @Test
    void c_update() {
        CovidStatus oldCovidStatus = covidStatusService.read(covidStatus.getStudentNumber());
        CovidStatus updatedCovidStatus = new CovidStatus.Builder().copy(oldCovidStatus).setSymptoms(true).build();
        assertNotNull(covidStatusService.update(updatedCovidStatus));
        System.out.println("Updated...");
        System.out.println("CovidStatus: " + updatedCovidStatus);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean isDeleted = covidStatusService.delete("217222943");
        assertTrue(isDeleted);
        System.out.println("Deleted: " + isDeleted);
    }

    @Test
    void d_getAll() {
        List<CovidStatus> covidStatusList = covidStatusService.getAll();
        covidStatusList.forEach( covidStatus -> System.out.println("CovidStatus: " + covidStatus));
    }
}