/*
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.NumberOfMoviesRented;
import za.ac.cput.factory.NumberOfMoviesRentedFactory;
import za.ac.cput.service.NumberOfMoviesRentedService;


import java.util.Set;

*/
/**
 * Author: Lance Kruger
 * Student Number: 218159501
 * Program: Number of Movies Rented out Controller
 *lk
 *//*

@RestController
@RequestMapping("/number of movies rented")
public class NumberOfMoviesRentedController {

    @Autowired
    private NumberOfMoviesRentedService numberOfMoviesRentedService;

    @PostMapping("/create")
    public NumberOfMoviesRented create(@RequestBody NumberOfMoviesRented numberOfMoviesRented){
        NumberOfMoviesRented newNumberOfMoviesRented = NumberOfMoviesRentedFactory.build(numberOfMoviesRented.getMovieID(),numberOfMoviesRented.getUserID(),numberOfMoviesRented.getNumMovies(),numberOfMoviesRented.getRentalID());
        return numberOfMoviesRentedService.create(newNumberOfMoviesRented);
    }

    @PostMapping("/update")
    public NumberOfMoviesRented update(NumberOfMoviesRented numberOfMoviesRented){
        return numberOfMoviesRentedService.update(numberOfMoviesRented);
    }

    @GetMapping("/read{id}")
    public NumberOfMoviesRented read(@PathVariable String id){
        return numberOfMoviesRentedService.read(id);
    }

    @DeleteMapping("/delete{id}")
    public boolean delete(@PathVariable String id){
        return numberOfMoviesRentedService.delete(id);
    }

    @GetMapping("/getall")
    public Set<NumberOfMoviesRented> getAll(){
        return  numberOfMoviesRentedService.getAll();
    }
}
*/
