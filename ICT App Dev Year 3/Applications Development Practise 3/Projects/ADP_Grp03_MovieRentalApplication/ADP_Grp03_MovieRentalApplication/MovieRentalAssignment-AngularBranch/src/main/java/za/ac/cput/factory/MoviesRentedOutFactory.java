package za.ac.cput.factory;
import za.ac.cput.entity.MovieRentedOut;
import java.util.UUID;

import static javax.swing.text.html.parser.DTDConstants.ID;


@Deprecated
public class MoviesRentedOutFactory {
    public static MovieRentedOut build(String movieID, int quantity){

        if (movieID.isEmpty() || quantity<0)
            return null;

        String ID= UUID.randomUUID().toString();

        return new MovieRentedOut.MovieRentedOutBuilder().
                setMovieID(ID).setQuantity(quantity).build();
    }
}
