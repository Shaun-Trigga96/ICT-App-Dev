package za.ac.cput.factory;
import za.ac.cput.entity.NumberOfMoviesRented;
import java.util.UUID;

@Deprecated
public class NumberOfMoviesRentedFactory {
    public static NumberOfMoviesRented build(int movieID, String userID, int rentalID, int numMovies){

        if (movieID<0|| userID.isEmpty() || rentalID<0 || numMovies<0)
            return null;

        String ID= UUID.randomUUID().toString();

        return new NumberOfMoviesRented.NumberOfMoviesRentedBuilder().
                setMovieID(movieID).setRentalID(rentalID).setNumMovies(numMovies).setUserID(ID).build();
    }
}
