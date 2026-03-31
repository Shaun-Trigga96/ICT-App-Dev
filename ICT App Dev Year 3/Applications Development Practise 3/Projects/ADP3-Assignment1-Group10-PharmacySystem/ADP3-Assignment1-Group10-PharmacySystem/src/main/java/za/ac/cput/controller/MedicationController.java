/*MedicationController.java
 * Controller class for Medication
 * Author: Ilyaas Davids (219466242)
 * Date: 11 Oct 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Medication;
import za.ac.cput.service.MedicationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/medication")
@Slf4j
public class MedicationController {

    private final MedicationServiceImpl medicationService;

    @Autowired
    public MedicationController(MedicationServiceImpl medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medication>> getAll(){
        List<Medication> medications = medicationService.getAll();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Medication> read(@PathVariable String id){
        log.info("read request:{}", id);
        Medication medication = this.medicationService.read(id);
        return ResponseEntity.ok(medication);
    }

    @PostMapping("/save")
    public ResponseEntity<Medication> save(@Valid @RequestBody Medication medication){
        Medication newMedication = medicationService.save(medication);
        return new ResponseEntity<>(newMedication,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Medication> update(@RequestBody Medication medication){
        Medication updateMedication = medicationService.save(medication);
        return new ResponseEntity<>(updateMedication,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")String id){
        medicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
