package za.ac.cput.controller;/*
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.StudioMovie;
import za.ac.cput.factory.StudioMovieFactory;
import za.ac.cput.service.StudioMovieServices;

import java.util.Set;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.StudioMovie;
import za.ac.cput.factory.StudioMovieFactory;
import za.ac.cput.service.StudioMovieServices;

import java.util.Set;

/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */

@RestController
@RequestMapping("/studioMovie")

public class StudioMovieController {
    @Autowired
    private StudioMovieServices studioMovieServices;

    @PostMapping("/create")
    public StudioMovie create(@RequestBody StudioMovie studioMovie){
        StudioMovie newStudioMovie = StudioMovieFactory.build(studioMovie.getStudioId(), studioMovie.getMovieId()); //checkout possibly add "Builder"
        return studioMovieServices.create(newStudioMovie);
    }

    @GetMapping("/read/{studioId}")
    public StudioMovie read(@PathVariable String studioId){
        return studioMovieServices.read(studioId);
    }

    @PostMapping("/update")
    public StudioMovie update(@RequestBody StudioMovie studioId){
        return studioMovieServices.update(studioId);
    }

    @DeleteMapping("/delete/{studioId}")
    public boolean delete(@PathVariable String studioId){
        return studioMovieServices.delete(studioId);
    }

    @GetMapping("/getall")
    public Set<StudioMovie> getAll(){
        return studioMovieServices.getAll();
    }

}

