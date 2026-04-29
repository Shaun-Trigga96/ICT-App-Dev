package za.ac.cput.repository;

/*
    IMovieRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/

import za.ac.cput.entity.Movie;
import java.util.Set;

public interface IMovieRepository extends IRepository<Movie, String> {
    public Set <Movie> getAll();
}
