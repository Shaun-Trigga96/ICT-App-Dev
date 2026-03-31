package za.ac.cput.repository;

import za.ac.cput.entity.MovieRentedOut;

import java.util.*;

@Deprecated
public interface IMovieRentedOut extends IRepository <MovieRentedOut, String> {
    public Set<MovieRentedOut> getAll();
}
