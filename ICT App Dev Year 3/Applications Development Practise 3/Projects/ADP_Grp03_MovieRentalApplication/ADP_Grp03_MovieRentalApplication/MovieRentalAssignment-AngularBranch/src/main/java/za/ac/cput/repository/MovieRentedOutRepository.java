package za.ac.cput.repository;

import za.ac.cput.entity.MovieRentedOut;

import java.util.*;
@Deprecated
public class MovieRentedOutRepository implements IMovieRentedOut {
    private static MovieRentedOutRepository repository = null;
    public Set<MovieRentedOut> movieRentedOutDB = null;

    public MovieRentedOutRepository() {

        movieRentedOutDB = new HashSet<MovieRentedOut>();
    }

    public static MovieRentedOutRepository getRepository() {
        if (repository == null) {
            repository = new MovieRentedOutRepository();
        }
        return repository;
    }

    @Override
    public Set<MovieRentedOut> getAll() {
        return movieRentedOutDB;
    }

    @Override
    public MovieRentedOut create(MovieRentedOut movieRentedOut) {
        boolean success = movieRentedOutDB.add(movieRentedOut);
        if (!success)
            return null;
        return movieRentedOut;
    }

    @Override
    public MovieRentedOut read(String movieID) {
        for (MovieRentedOut r : movieRentedOutDB)
            if (r.getMovieID().equals(movieID))
                return r;
    return null;
    }

    @Override
    public MovieRentedOut update(MovieRentedOut movieRentedOut) {
        MovieRentedOut oldMovieRentedOut = read(movieRentedOut.getMovieID());
        if (oldMovieRentedOut != null) {
            movieRentedOutDB.remove(oldMovieRentedOut);
            movieRentedOutDB.add(movieRentedOut);
            return movieRentedOut;
        }
        return null;
    }

    @Override
    public boolean delete(String movieID) {
        MovieRentedOut movieRentedOutToDelete = read(movieID);
        if (movieRentedOutToDelete == null)
            return false;
        movieRentedOutDB.remove(movieRentedOutToDelete);
        return true;
    }

}


