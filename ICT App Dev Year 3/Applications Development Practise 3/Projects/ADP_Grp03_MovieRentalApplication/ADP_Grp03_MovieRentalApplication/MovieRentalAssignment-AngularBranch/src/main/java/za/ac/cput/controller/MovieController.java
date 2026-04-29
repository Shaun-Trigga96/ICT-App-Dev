package za.ac.cput.controller;
/*
    MovieController.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Movie;
import za.ac.cput.factory.MovieFactory;
import za.ac.cput.service.MovieService;

import java.util.Set;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/create")
    public Movie create(@RequestBody Movie movie) {
        Movie newMovie = MovieFactory.build(movie.getTitle(), movie.getReleaseDate(), movie.getGenres(),movie.getStudio(),movie.getMainActors(), movie.getPrice(), movie.getStock());
        return movieService.create(newMovie);
    }

    @GetMapping("/read{movieId}")
    public Movie read(@PathVariable String movieId){
        return movieService.read(movieId);
    }

    @PostMapping("/update")
    public Movie update(@RequestBody Movie movie){
        return movieService.update(movie);
    }

    @DeleteMapping("/delete{movieId}")
    public boolean delete(@PathVariable String movieId){
        return movieService.delete(movieId);
    }

    @GetMapping("/getall")
    public Set <Movie> getAll(){
        return movieService.getAll();
    }
}
