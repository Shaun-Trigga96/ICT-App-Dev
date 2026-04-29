package za.ac.cput.controller;
/*
    RatingController.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Rating;
import za.ac.cput.factory.RatingFactory;
import za.ac.cput.service.RatingService;

import java.util.Set;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public Rating create(@RequestBody Rating rating) {
        Rating newRating = RatingFactory.build(rating.getRating());
        return ratingService.create(newRating);
    }

    @GetMapping("/read{ratingId}")
    public Rating read(@PathVariable String ratingId){
        return ratingService.read(ratingId);
    }

    @PostMapping("/update")
    public Rating update(@RequestBody Rating rating){
        return ratingService.update(rating);
    }

    @DeleteMapping("/delete{ratingId}")
    public boolean delete(@PathVariable String ratingId){
        return ratingService.delete(ratingId);
    }

    @GetMapping("/getall")
    public Set<Rating> getAll(){
        return ratingService.getAll();
    }
}
