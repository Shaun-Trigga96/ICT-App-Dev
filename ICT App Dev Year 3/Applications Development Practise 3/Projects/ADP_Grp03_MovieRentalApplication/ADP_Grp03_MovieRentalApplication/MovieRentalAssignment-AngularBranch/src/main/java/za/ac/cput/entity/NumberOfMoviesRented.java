package za.ac.cput.entity;
/**
 * Author: Lance Kruger
 * Student Number: 218159501
 * Program: Number of movies rented of builder pattern
 *
 */

@Deprecated
public class NumberOfMoviesRented {
    private String userID;
    private int rentalID;
    private int movieID;
    private int numMovies;

    private NumberOfMoviesRented(NumberOfMoviesRentedBuilder numberOfMoviesRentedBuilder) {
        this.userID = numberOfMoviesRentedBuilder.userID;
        this.rentalID = numberOfMoviesRentedBuilder.rentalID;
        this.movieID = numberOfMoviesRentedBuilder.movieID;
        this.numMovies = numberOfMoviesRentedBuilder.numMovies;


    }

    public String getUserID() {
        return userID;
    }

    public int getRentalID() {
        return rentalID;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getNumMovies() {
        return numMovies;
    }



    public static class NumberOfMoviesRentedBuilder {
        private int rentalID, movieID, numMovies;
        private String userID;


        public NumberOfMoviesRentedBuilder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public NumberOfMoviesRentedBuilder setRentalID(int rentalID) {
            this.rentalID = rentalID;
            return this;
        }

        public NumberOfMoviesRentedBuilder setMovieID(int movieID) {
            this.movieID = movieID;
            return this;
        }

        public NumberOfMoviesRentedBuilder setNumMovies(int numMovies) {
            this.numMovies = numMovies;
            return this;
        }

        public NumberOfMoviesRentedBuilder copy(NumberOfMoviesRented numberOfMoviesRented)
        {
            this.userID = numberOfMoviesRented.userID;
            this.rentalID = numberOfMoviesRented.rentalID;
            this.movieID = numberOfMoviesRented.movieID;
            this.numMovies = numberOfMoviesRented.numMovies;

            return this;
        }

        public NumberOfMoviesRented build() {
            return new NumberOfMoviesRented(this);
        }

        @Override
        public String toString() {
            return "NumberOfMoviesRented{" +
                    "userID=" + userID +
                    ", rentalID=" + rentalID +
                    ", movieID=" + movieID +
                    ", numMovies=" + numMovies +
                    '}';
        }
    }
}
