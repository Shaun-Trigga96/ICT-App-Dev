
package za.ac.cput.controller;

/* MovieGenreController.java

        Author: Marchello Carolus 218234457

        */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.MovieGenre;
import za.ac.cput.factory.MovieGenreFactory;
import za.ac.cput.service.MovieGenreService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movieGenre")
public class MovieGenreController {

    @Autowired
    private MovieGenreService movieGenreService;

    //@RequestMapping( value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public MovieGenre create(@RequestBody MovieGenre movieGenre) {
        MovieGenre newMovieGenre = MovieGenreFactory.build(movieGenre.getGenreId(), movieGenre.getMovieId());

        return movieGenreService.create(newMovieGenre);
    }

    @GetMapping("/read")
    public MovieGenre read(@RequestBody MovieGenre movieGenre){
        return movieGenreService.read(movieGenre.getGenreId());

    }

    @PostMapping("/update")
    public MovieGenre update(@RequestBody MovieGenre genre){
        MovieGenre updateMovieGenre = MovieGenreFactory.build(genre.getMovieId(), genre.getGenreId());
        return movieGenreService.update(updateMovieGenre);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody MovieGenre movieGenre){
        if (movieGenreService.delete(movieGenre.getGenreId()))
            return "Genre Id Deleted";
        else
            return "Could not delete Movie Genre object ";

    }

    @GetMapping("/getAll")
    public List<MovieGenre> getAll(){
        return movieGenreService.getAll();
    }




}
