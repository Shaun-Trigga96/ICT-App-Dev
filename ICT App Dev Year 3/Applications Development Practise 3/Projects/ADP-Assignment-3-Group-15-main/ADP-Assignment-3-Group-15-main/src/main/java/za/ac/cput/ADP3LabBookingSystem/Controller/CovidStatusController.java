/*
 * CovidStatusController.java
 * Author: Grant Metcalf (217222943)
 * Date: October 2021
 * */

package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.CovidStatus;
import za.ac.cput.ADP3LabBookingSystem.Factory.CovidStatusFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.CovidStatusService;

import java.util.List;

@RestController
@RequestMapping("/covidstatus")
public class CovidStatusController {

    @Autowired
    private CovidStatusService covidStatusService;

    @PostMapping("/create")
    public CovidStatus create(@RequestBody CovidStatus covidStatus) {
        CovidStatus newCovidStatus = CovidStatusFactory.createCovidStatus(covidStatus.getStudentNumber(), covidStatus.getTemperature(), covidStatus.getSymptoms());
        return covidStatusService.create(newCovidStatus);
    }

    @GetMapping("/read/{studentNumber}")
    public CovidStatus read(@PathVariable String studentNumber) {
        return covidStatusService.read(studentNumber);
    }

    @PostMapping("/update")
    public CovidStatus update(@RequestBody CovidStatus covidStatus) {
        return covidStatusService.update(covidStatus);
    }

    @PostMapping("/delete/{studentNumber}")
    public boolean delete(@PathVariable String studentNumber) {
        return covidStatusService.delete(studentNumber);
    }

    @GetMapping("/getall")
    public List<CovidStatus> getAll() {
        return covidStatusService.getAll();
    }

}
