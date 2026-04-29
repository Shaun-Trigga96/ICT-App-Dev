package za.ac.cput.controller;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UserRentalPrice;
import za.ac.cput.factory.UserRentalPriceFactory;
import za.ac.cput.service.UserRentalPriceService;

import java.util.Set;
@Deprecated
@RestController
@RequestMapping("/UserRentalPrice")
public class UserRentalPriceController {

    @Autowired
    private UserRentalPriceService uRPService;
    
    @PostMapping("/create")
    public UserRentalPrice create(@RequestBody UserRentalPrice userRentalPrice){
        UserRentalPrice newURP = UserRentalPriceFactory.build(userRentalPrice.getDuration(), userRentalPrice.getAmount());
        return uRPService.create(newURP);
    }

    @PostMapping("/update")
    public UserRentalPrice update(UserRentalPrice userRentalPrice){
        return uRPService.update(userRentalPrice);
    }

    @GetMapping("/read{id}")
    public UserRentalPrice read(@PathVariable String id){
        return uRPService.read(id);
    }

    @DeleteMapping("/delete{id}")
        public boolean delete(@PathVariable String id){
           return uRPService.delete(id);
        }

    @GetMapping("/getall")
    public Set<UserRentalPrice> getAll() {
        return uRPService.getAll();
    }

}
