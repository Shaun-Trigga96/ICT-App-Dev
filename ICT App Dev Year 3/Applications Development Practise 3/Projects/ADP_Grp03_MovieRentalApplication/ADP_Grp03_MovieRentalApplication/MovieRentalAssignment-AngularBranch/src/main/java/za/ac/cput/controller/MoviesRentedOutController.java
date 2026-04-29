/*
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.MovieRentedOut;
import za.ac.cput.factory.MoviesRentedOutFactory;
import za.ac.cput.service.MovieRentedOutService;

import java.util.Set;

*/
/**
 * Author: Lance Kruger
 * Student Number: 218159501
 * Program: Movies Rented out Controller
 *lk
 *//*

@RestController
@RequestMapping("/moviesrented")
public class MoviesRentedOutController {
    @Autowired
    private MovieRentedOutService movieRentedOutService;

    @PostMapping("/create")
    public MovieRentedOut create(@RequestBody MovieRentedOut movieRentedOut) {
        MovieRentedOut newMovieRentedOut = MoviesRentedOutFactory.build(movieRentedOut.getMovieID(), movieRentedOut.getQuantity());
        return movieRentedOutService.create(newMovieRentedOut);
    }

    @GetMapping("/read{movieID}")
    public MovieRentedOut read(@PathVariable String movieID){
        return movieRentedOutService.read(movieID);
    }

    @PostMapping("/update")
    public MovieRentedOut update(@RequestBody MovieRentedOut movieRentedOut){
        return movieRentedOutService.update(movieRentedOut);
    }

    @DeleteMapping("/delete{movieID}")
    public boolean delete(@PathVariable String movieID){
        return movieRentedOutService.delete(movieID);
    }

    @GetMapping("/getall")
    public Set<MovieRentedOut> getAll(){
        return movieRentedOutService.getAll();
    }
}
*/
