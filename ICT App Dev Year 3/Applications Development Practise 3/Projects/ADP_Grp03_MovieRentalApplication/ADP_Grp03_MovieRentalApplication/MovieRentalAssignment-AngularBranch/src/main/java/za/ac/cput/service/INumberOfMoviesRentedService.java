package za.ac.cput.service;

import za.ac.cput.entity.NumberOfMoviesRented;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 *lk
 */

import java.util.Set;

public interface INumberOfMoviesRentedService extends IService <NumberOfMoviesRented, String> {
    Set<NumberOfMoviesRented> getAll();
}
