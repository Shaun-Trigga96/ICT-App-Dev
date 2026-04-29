package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*
    Rating.java
    Entity for Rating
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/
@Entity
public class Rating implements Serializable {

    protected Rating(){

    }

    @Id private String movieId;
    private double rating;

    private Rating(RatingBuilder RatingBuilder){
        this.movieId = RatingBuilder.movieId;
        this.rating = RatingBuilder.rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public double getRating() {
        return rating;
    }

    public static class RatingBuilder {
        private String movieId;
        private double rating;

        public RatingBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public RatingBuilder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Rating.RatingBuilder copy(Rating rating){
            this.movieId=rating.movieId;
            this.rating=rating.rating;
            return this;
        }

        public Rating build(){
            return new Rating(this);
        }


    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
