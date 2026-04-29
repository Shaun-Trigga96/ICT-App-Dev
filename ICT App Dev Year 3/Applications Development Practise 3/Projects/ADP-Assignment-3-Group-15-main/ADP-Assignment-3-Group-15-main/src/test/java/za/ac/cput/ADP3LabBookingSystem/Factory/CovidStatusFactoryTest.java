/*
 * CovidStatusFactoryTest.java
 * Test Class for createCovidStatus.
 * Author: Grant Metcalf (217222943)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CovidStatusFactoryTest {

    @Test
    void createCovidStatus() {
        CovidStatus covidStatus = CovidStatusFactory.createCovidStatus("217222943",36.4,false);
        Assertions.assertEquals(covidStatus,covidStatus);
        System.out.println(covidStatus);
    }
}