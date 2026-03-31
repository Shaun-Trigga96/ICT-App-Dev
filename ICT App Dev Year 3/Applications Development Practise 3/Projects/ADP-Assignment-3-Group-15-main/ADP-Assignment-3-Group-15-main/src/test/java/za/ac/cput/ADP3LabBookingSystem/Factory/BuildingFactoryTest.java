package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.ADP3LabBookingSystem.Entity.Building;

import static org.junit.jupiter.api.Assertions.*;

class BuildingFactoryTest {
    @Test
    public void createBuilding() {
        Building building = BuildingFactory.createBuilding("Engineering");
        System.out.println(building);

    }
}