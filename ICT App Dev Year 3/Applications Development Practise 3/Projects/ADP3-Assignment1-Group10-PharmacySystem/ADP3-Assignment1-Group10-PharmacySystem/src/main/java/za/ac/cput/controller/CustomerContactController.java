/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactController.java
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerContact;
import za.ac.cput.service.CustomerContactServiceImpl;

@RestController
@RequestMapping("/customer-contact")
public class CustomerContactController {
    private final CustomerContactServiceImpl service;
    @Autowired
    public CustomerContactController(CustomerContactServiceImpl service){
        this.service = service;
    }

    @PostMapping("/save")
    public CustomerContact save(@RequestBody CustomerContact customerContact) {
        return this.service.save(customerContact);
    }

    @GetMapping("/find/{id}")
    public CustomerContact find(@PathVariable long id) {
        return this.service.find(id);
    }

    @PostMapping("/update")
    public CustomerContact update(@RequestBody CustomerContact customerContact) {
        return this.service.update(customerContact);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody CustomerContact customerContact) {
        return this.service.delete(customerContact);
    }

}
