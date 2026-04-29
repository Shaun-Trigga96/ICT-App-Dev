/*
 * CovidStatusService.java
 * Author: Grant Metcalf (217222943)
 * Date: October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;
import za.ac.cput.ADP3LabBookingSystem.Repository.CovidStatusRepository;

import java.util.List;

@Service
public class CovidStatusService implements ICovidStatusService {

    public static CovidStatusService service = null;

    @Autowired
    private CovidStatusRepository repository;

    @Override
    public CovidStatus create(CovidStatus covidStatus) {
        return this.repository.save(covidStatus);
    }

    @Override
    public CovidStatus read(String studentNumber) {
        return this.repository.findById(studentNumber).orElse(null);
    }

    @Override
    public CovidStatus update(CovidStatus covidStatus) {
        if (this.repository.existsById(covidStatus.getStudentNumber()))
            return this.repository.save(covidStatus);
        return null;
    }

    @Override
    public boolean delete(String studentNumber) {
        this.repository.deleteById(studentNumber);
        if (this.repository.existsById(studentNumber))
            return false;
        else
            return true;
    }

    @Override
    public List<CovidStatus> getAll() {
        return this.repository.findAll();
    }
}
