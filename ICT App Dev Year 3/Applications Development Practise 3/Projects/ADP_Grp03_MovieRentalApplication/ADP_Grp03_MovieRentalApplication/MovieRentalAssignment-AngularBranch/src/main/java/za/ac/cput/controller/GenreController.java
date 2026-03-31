
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Genre;
import za.ac.cput.factory.GenreFactory;
import za.ac.cput.service.GenreService;

import java.util.Set;

/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */

@RestController
@RequestMapping("/genre")

public class GenreController {
    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)//only need one to declaire post method
    //@PostMapping("/create")
    public Genre create(@RequestBody Genre genre){
        Genre newGenre = GenreFactory.build(genre.getGenreId(),genre.getGenreName(), genre.getDescription());//("HOR","Horror", "These horrors will give you sleepless nights and and scream like never before"); //checkout
        return genreService.create(newGenre);
    }

    @GetMapping("/read/{genreId}")
    public Genre read(@PathVariable String genreId){
        return genreService.read(genreId);
    }

    @PostMapping("/update")
    public Genre update(@RequestBody Genre genreName){
        return genreService.update(genreName);
    }

    @DeleteMapping("/delete/{genreId}")
    public boolean delete(@PathVariable String genreId){
        return genreService.delete(genreId);
    }

    @GetMapping("/getall")
    public Set<Genre> getAll(){
        return genreService.getAll();
    }

    @GetMapping("/getSingleGenre")
    public Set<Genre> getSingleGenre(){
        return genreService.getSingleGenre();
    }

}

