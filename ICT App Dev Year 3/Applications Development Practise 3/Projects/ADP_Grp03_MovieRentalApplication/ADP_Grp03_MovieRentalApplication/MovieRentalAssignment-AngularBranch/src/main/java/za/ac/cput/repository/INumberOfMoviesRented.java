package za.ac.cput.repository;

import za.ac.cput.entity.NumberOfMoviesRented;

import java.util.Set;
@Deprecated
public interface INumberOfMoviesRented extends IRepository <NumberOfMoviesRented, String> {
    public Set<NumberOfMoviesRented> getAll();
}
