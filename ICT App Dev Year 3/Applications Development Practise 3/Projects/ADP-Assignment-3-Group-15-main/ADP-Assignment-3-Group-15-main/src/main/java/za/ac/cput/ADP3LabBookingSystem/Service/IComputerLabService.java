/*
 * IComputerLabService.java
 * IComputerLabService interface class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import java.util.List;
import java.util.Set;

public interface IComputerLabService extends IService<ComputerLab, String> {
    public List<ComputerLab> getAll();

    //TODO public List<ComputerLab> getAllByAvailability();
    //TODO public List<ComputerLab> getAllByCapacity();
    //TODO public List<ComputerLab> getAllByBuildingId();
}
