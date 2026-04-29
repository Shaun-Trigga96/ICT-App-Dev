/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * InventoryController.java
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.service.InventoryServiceImpl;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryServiceImpl service;
    @Autowired
    public InventoryController(InventoryServiceImpl service){
        this.service = service;
    }

    @PostMapping("/save")
    public Inventory save(@RequestBody Inventory inventory) {
        return this.service.save(inventory);
    }

    @GetMapping("/find/{id}")
    public Inventory find(@PathVariable long id) {
        return this.service.find(id);
    }

    @PostMapping("/update")
    public Inventory update(@RequestBody Inventory inventory) {
        return this.service.update(inventory);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody Inventory inventory) {
        return this.service.delete(inventory);
    }

}
