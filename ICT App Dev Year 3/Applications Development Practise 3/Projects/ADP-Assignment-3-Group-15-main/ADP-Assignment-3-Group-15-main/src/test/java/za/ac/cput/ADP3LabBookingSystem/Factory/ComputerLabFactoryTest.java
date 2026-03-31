/*
 * ComputerLabFactory.java
 * Factory for the ComputerLab.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 10 June 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import static org.junit.jupiter.api.Assertions.*;

class ComputerLabFactoryTest {

    @Test
    public void createComputerLab(){
        ComputerLab computerLab = ComputerLabFactory.createComputerLab("1.19", "1002", 35, true);
        System.out.println(computerLab);
    }
}