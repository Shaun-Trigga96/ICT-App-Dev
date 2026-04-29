package za.ac.cput.entity;

/*
    Movie.java
    Entity for the Movie
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
    @Id private String movieId;
    private String title,releaseDate, genres, studio, mainActors;
    private int stock;
    private double price;

    protected Movie(){}

    private Movie(MovieBuilder MovieBuilder){
        this.movieId = MovieBuilder.movieId;
        this.genres = MovieBuilder.genres;
        this.studio = MovieBuilder.studio;
        this.title = MovieBuilder.title;
        this.releaseDate = MovieBuilder.releaseDate;
        this.stock = MovieBuilder.stock;
        this.mainActors = MovieBuilder.mainActors;
        this.price = MovieBuilder.price;
    }

    public String getMainActors() {
        return mainActors;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getGenres() {
        return genres;
    }

    public String getStudio() {
        return studio;
    }

    public static class MovieBuilder {
        public int stock;
        public double price;
        private String title,releaseDate,movieId,genres, studio,mainActors;

        public MovieBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public MovieBuilder setGenres(String genres) {
            this.genres = genres;
            return this;
        }

        public MovieBuilder setStudio(String studio) {
            this.studio = studio;
            return this;
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public MovieBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public MovieBuilder setMainActors(String mainActors) {
            this.mainActors = mainActors;
            return this;
        }

        public MovieBuilder copy(Movie movie){
            this.movieId=movie.movieId;
            this.studio =movie.studio;
            this.genres=movie.genres;
            this.releaseDate=movie.releaseDate;
            this.title=movie.title;
            this.price=movie.price;
            this.mainActors=movie.mainActors;
            this.stock=movie.stock;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genres='" + genres + '\'' +
                ", studio='" + studio + '\'' +
                ", mainActors='" + mainActors + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
