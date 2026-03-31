package za.ac.cput.factory;
/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */
import za.ac.cput.entity.StudioMovie;

import java.util.UUID;

public class StudioMovieFactory {

    public static StudioMovie build(String studioId, String movieId){
        if(studioId.isEmpty() || movieId.isEmpty())
            return null;
        String id = UUID.randomUUID().toString();

        return new StudioMovie.studioBuilder().setStudioId(studioId).setMovieId(movieId).build();
    }
}
