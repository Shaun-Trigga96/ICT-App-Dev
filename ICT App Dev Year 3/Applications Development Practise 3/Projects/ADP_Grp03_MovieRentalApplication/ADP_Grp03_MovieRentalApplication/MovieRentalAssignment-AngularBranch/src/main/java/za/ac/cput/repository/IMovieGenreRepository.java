package za.ac.cput.repository;

import za.ac.cput.entity.MovieGenre;

import java.util.List;

/* Studio.java
        studio repo
        Author: Marchello Carolus 218234457
        Date: 26 July 2021
        */
@Deprecated
public interface IMovieGenreRepository extends IRepository <MovieGenre, String> {
    public List<MovieGenre> getAll();


}
