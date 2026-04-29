package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/* MovieGenre.java
        Entity for MovieGenre
        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */
@Entity
public class MovieGenre {

    @Id
    private String genreId;
    private String movieId;

    public MovieGenre() {

    }
    private MovieGenre(Builder builder) {
        this.genreId = builder.genreId;
        this.movieId = builder.movieId;

    }

    public String getGenreId() {
        return genreId;
    }

    public String getMovieId() {
        return movieId;
    }

    public static class Builder{

        private String genreId, movieId;

        public Builder setGenreId(String genreId) {
            this.genreId = genreId;

            return this;
        }
        public Builder setMovieId(String movieId) {
            this.movieId = movieId;

            return this;
        }

        public MovieGenre build(){

            return new MovieGenre(this);
        }

        public Builder copy(MovieGenre movies){

            this.genreId = movies.genreId;
            this.movieId = movies.movieId;
            return this;
        }

    }
    @Override
    public String toString() {
        return "Builder{" +
                "GenreID ='" + genreId + '\'' +
                ", MovieId ='" + movieId + '\'' +

                '}';
    }
}
