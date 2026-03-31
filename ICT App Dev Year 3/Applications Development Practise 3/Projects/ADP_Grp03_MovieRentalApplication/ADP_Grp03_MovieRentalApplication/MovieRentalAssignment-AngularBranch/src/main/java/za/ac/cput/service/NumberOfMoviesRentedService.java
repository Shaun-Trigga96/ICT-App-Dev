package za.ac.cput.service;

import za.ac.cput.entity.NumberOfMoviesRented;
import za.ac.cput.repository.NumberOfMoviesRentedRepository;

import java.util.Set;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 *lk
 */

public class NumberOfMoviesRentedService implements INumberOfMoviesRentedService {

    private static NumberOfMoviesRentedService service = null;
    private NumberOfMoviesRentedRepository numberOfMoviesRentedDB = null;

    private NumberOfMoviesRentedService(){this.numberOfMoviesRentedDB = NumberOfMoviesRentedRepository.getRepository(); }

    public static NumberOfMoviesRentedService getService(){
        if(service == null){
            service =new NumberOfMoviesRentedService();
        }

        return service;
    }

    @Override
    public NumberOfMoviesRented create(NumberOfMoviesRented numberOfMoviesRented) {
        return this.numberOfMoviesRentedDB.create(numberOfMoviesRented);
    }

    @Override
    public NumberOfMoviesRented read(String userID) {
        return this.numberOfMoviesRentedDB.read(userID);
    }

    @Override
    public NumberOfMoviesRented update(NumberOfMoviesRented numberOfMoviesRented) {
        return this.numberOfMoviesRentedDB.update(numberOfMoviesRented);
    }

    @Override
    public boolean delete(String rentalID) {

        return this.numberOfMoviesRentedDB.delete(rentalID);
    }

    @Override
    public Set<NumberOfMoviesRented> getAll() {
        return this.numberOfMoviesRentedDB.getAll();
    }

}
