package za.ac.cput.factory;

/*
    RatingFactory.java
    Factory class for the Rating entity
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import za.ac.cput.entity.Rating;

import java.util.UUID;

public class RatingFactory {
    public static Rating build(double rating){

        String movieId= UUID.randomUUID().toString();

        return new Rating.RatingBuilder().
                setMovieId(movieId).setRating(rating)
                .build();
    }
}
