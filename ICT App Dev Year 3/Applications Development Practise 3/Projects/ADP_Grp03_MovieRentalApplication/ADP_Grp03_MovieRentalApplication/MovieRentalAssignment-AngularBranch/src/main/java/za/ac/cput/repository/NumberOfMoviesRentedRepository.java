package za.ac.cput.repository;

import za.ac.cput.entity.NumberOfMoviesRented;

import java.util.*;
@Deprecated
public class NumberOfMoviesRentedRepository implements INumberOfMoviesRented {
        private static NumberOfMoviesRentedRepository repository = null;
        public Set<NumberOfMoviesRented> numberOfMoviesRentedDB = null;


    public NumberOfMoviesRentedRepository() {

            numberOfMoviesRentedDB = new HashSet<NumberOfMoviesRented>();
        }

        public static NumberOfMoviesRentedRepository getRepository() {
            if (repository == null) {
                repository = new NumberOfMoviesRentedRepository();
            }
            return repository;
        }
        public Set<NumberOfMoviesRented> getNumberOfMoviesRentedDB() {
        return numberOfMoviesRentedDB;
         }

        @Override
        public Set<NumberOfMoviesRented> getAll() {
            return numberOfMoviesRentedDB;
        }

        @Override
        public NumberOfMoviesRented create(NumberOfMoviesRented NumberOfMoviesRented) {
            boolean success = numberOfMoviesRentedDB.add(NumberOfMoviesRented);
            if (!success)
                return null;
            return NumberOfMoviesRented;
        }

        @Override
        public NumberOfMoviesRented read(String userID) {
            for (NumberOfMoviesRented r : numberOfMoviesRentedDB)
                if (r.getUserID().equals(userID))
                    return r;
            return null;
        }

        @Override
        public NumberOfMoviesRented update(NumberOfMoviesRented numberOfMoviesRented) {
            NumberOfMoviesRented oldNumberOfMoviesRented = read(numberOfMoviesRented.getUserID());
            if (oldNumberOfMoviesRented != null) {
                numberOfMoviesRentedDB.remove(oldNumberOfMoviesRented);
                numberOfMoviesRentedDB.add(numberOfMoviesRented);
                return numberOfMoviesRented;
            }
            return null;
        }

        @Override
        public boolean delete(String movieID) {
            NumberOfMoviesRented numberOfMoviesRentedToDelete = read(movieID);
            if (numberOfMoviesRentedToDelete == null)
                return false;
            numberOfMoviesRentedDB.remove(numberOfMoviesRentedToDelete);
            return true;
        }

    }
