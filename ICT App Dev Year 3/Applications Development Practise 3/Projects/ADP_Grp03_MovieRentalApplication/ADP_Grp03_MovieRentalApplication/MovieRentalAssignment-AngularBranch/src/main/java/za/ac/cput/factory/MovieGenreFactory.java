package za.ac.cput.factory;

/* MovieGenre.java
        Factory class for MovieGenre entity
        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */
import za.ac.cput.entity.MovieGenre;


public class MovieGenreFactory {

    public static MovieGenre build(String genreId, String movieId){
        if(genreId.isEmpty() ||  movieId.isEmpty())
            return null;

        MovieGenre movieGenre = new MovieGenre.Builder()
                .setGenreId(genreId)
                .setMovieId(movieId)
                .build();
        return movieGenre;
    }
}
