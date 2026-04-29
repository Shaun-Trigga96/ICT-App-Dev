package za.ac.cput.controller;

/* PharmacyContactController.java
Controller for the PharmacyContact
Author: Waseem Dollie (216040566)
Date: 15 October 2022 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.service.PharmacyContactServiceImpl;
import za.ac.cput.service.PharmacyServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/pharmacyContact")
@Slf4j
public class PharmacyContactController {

    private final PharmacyContactServiceImpl pharmacyContactService;

    @Autowired
    public PharmacyContactController(PharmacyContactServiceImpl pharmacyContactService){this.pharmacyContactService = pharmacyContactService;}

    @PostMapping("save")
    public ResponseEntity<PharmacyContact> save(@Valid @RequestBody PharmacyContact pharmacyContact){
        log.info("save request:{}", pharmacyContact);
        PharmacyContact save = pharmacyContactService.save(pharmacyContact);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{pharmId}")
    public ResponseEntity<PharmacyContact> read (@PathVariable String pharmId){

        log.info("read request:{}", pharmId);
        PharmacyContact pharmacyContact = this.pharmacyContactService.read(pharmId);
        return ResponseEntity.ok(pharmacyContact);
    }

    @GetMapping("delete/{}")
    public ResponseEntity<Void>delete(@PathVariable String pharmID)
    {
        log.info("Read request:{}", pharmID);
        this.pharmacyContactService.delete(pharmID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<PharmacyContact>>findAll(){
        List<PharmacyContact>pharmacyContactList = this.pharmacyContactService.getAll();
        return ResponseEntity.ok(pharmacyContactList);
    }
}
