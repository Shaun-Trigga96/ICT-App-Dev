package za.ac.cput.controller;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.UserRental;
import za.ac.cput.factory.UserRentalFactory;
import za.ac.cput.service.UserRentalService;

import java.util.Set;

@RestController
@RequestMapping("/userrental")
public class UserRentalController {

    @Autowired
    private UserRentalService userRentalService;

    @PostMapping("/create")
    public UserRental create(@RequestBody UserRental userRental){
        UserRental newUserRental = UserRentalFactory.build(userRental.getUserId(),userRental.getMovieId());
        return userRentalService.create(newUserRental);
    }

    @PostMapping("/update")
    public UserRental update(@RequestBody UserRental userRental){
        return userRentalService.update(userRental);
    }

    @GetMapping("/read{id}")
    public UserRental read(@PathVariable String id){
        return userRentalService.read(id);
    }

    @DeleteMapping("/delete{id}")
    public boolean delete(@PathVariable String id){
        return userRentalService.delete(id);
    }

    @GetMapping("/getall")
    public Set<UserRental> getAll(){
        return  userRentalService.getAll();
    }
}
