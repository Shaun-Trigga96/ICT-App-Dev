package za.ac.cput.factory;
/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */
import za.ac.cput.entity.Genre;

import java.util.UUID;

public class GenreFactory {

    public static Genre build(String genreId, String genreName, String description){
        if (genreId.isEmpty() || genreName.isEmpty() || description.isEmpty())
            return null;
        String id = UUID.randomUUID().toString();

        return new Genre.genreBuilder()
                .setGenreId(genreId).setGenreName(genreName).setDescription(description).build();
    }

}
