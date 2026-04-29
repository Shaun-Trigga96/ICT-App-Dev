/*
 * ComputerLabController.java
 * ComputerLabController class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 09 October 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;
import za.ac.cput.ADP3LabBookingSystem.Factory.ComputerLabFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.ComputerLabService;

import java.util.List;

@RestController
@RequestMapping("/computerlab")
public class ComputerLabController {

    @Autowired
    private ComputerLabService computerLabService;

    @PostMapping("/create")
    public ComputerLab create(@RequestBody ComputerLab computerLab) {
        ComputerLab newComputerLab1 = ComputerLabFactory.createComputerLab(computerLab.getLabId(), computerLab.getBuildingId(), computerLab.getCapacity(), computerLab.getAvailability());
        return computerLabService.create(newComputerLab1);
    }

    @GetMapping("/read/{labId}")
    public ComputerLab read(@PathVariable String labId){
        return computerLabService.read(labId);
    }

    @PostMapping("/update")
    public ComputerLab update(@RequestBody ComputerLab computerLab) {
        return computerLabService.update(computerLab);
    }

    @PostMapping("/delete/{labId}")
    public boolean delete(@PathVariable String labId) {
        return computerLabService.delete(labId);
    }

    @GetMapping("/getall")
    public List<ComputerLab> getAll(){ return computerLabService.getAll(); }
}
