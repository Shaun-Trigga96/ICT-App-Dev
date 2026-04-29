package za.ac.cput.controller;

/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 28 August 2021
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.ContactType;
import za.ac.cput.factory.ContactTypeFactory;
import za.ac.cput.service.ContactTypeService;


import java.util.Set;
@RestController
@RequestMapping("/contactType")

public class ContactTypeController {

    @Autowired
    private ContactTypeService contactTypeService;

    @PostMapping("/create")
    public ContactType create(@RequestBody ContactType contactType) {
        ContactType newContactType = ContactTypeFactory.build(contactType.getName(),contactType.getDescription());
        return contactTypeService.create(newContactType);
    }

    @GetMapping("/read/{contactTypeId}")
    public ContactType read(@PathVariable String contactTypeId){
        return contactTypeService.read(contactTypeId);
    }

    @PostMapping("/update")
    public ContactType update(@RequestBody ContactType contactType){
        return contactTypeService.update(contactType);
    }

    @DeleteMapping("/delete/{contactTypeId}")
    public boolean delete(@PathVariable String contactTypeId){
        return contactTypeService.delete(contactTypeId);
    }
    @GetMapping("/getall")
    public Set<ContactType> getAll(){
        return contactTypeService.getAll();
    }



}
