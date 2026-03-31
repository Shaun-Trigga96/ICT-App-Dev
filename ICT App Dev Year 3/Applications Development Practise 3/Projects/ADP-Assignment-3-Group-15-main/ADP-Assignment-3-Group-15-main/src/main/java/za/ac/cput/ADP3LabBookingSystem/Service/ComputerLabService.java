/*
 * ComputerLabService.java
 * ComputerLabService class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Repository.ComputerLabRepository;

import java.util.List;

@Service
public class ComputerLabService implements IComputerLabService {
    private static ComputerLabService service = null;

    @Autowired
    private ComputerLabRepository repository;

    @Override
    public ComputerLab create(ComputerLab computerLab) {
        return this.repository.save(computerLab);
    }

    @Override
    public ComputerLab read(String labId) {
        return this.repository.findById(labId).orElse(null);
    }

    @Override
    public ComputerLab update(ComputerLab computerLab) {
       if (this.repository.existsById(computerLab.getLabId()))
           return  this.repository.save(computerLab);
       return null;
    }

    @Override
    public boolean delete(String labId) {
        this.repository.deleteById(labId);

        if (this.repository.existsById(labId))
            return false;
        else
            return true;
    }

    @Override
    public List<ComputerLab> getAll() {
        return this.repository.findAll();
    }
}
