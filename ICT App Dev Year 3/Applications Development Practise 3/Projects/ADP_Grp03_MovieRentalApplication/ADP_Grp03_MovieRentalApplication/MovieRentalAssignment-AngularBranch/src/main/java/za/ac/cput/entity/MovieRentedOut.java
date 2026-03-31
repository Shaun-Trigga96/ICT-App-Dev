package za.ac.cput.entity;

/**
 * Author: Lance Kruger
 * Student Number: 218159501
 * Program: Movies Rented out of builder pattern
 *
 */
@Deprecated
public class MovieRentedOut {
    private static String movieID;
    private int quantity;

    private MovieRentedOut(MovieRentedOutBuilder MovieRentedOutBuilder) {
        this.movieID = MovieRentedOutBuilder.movieID;
        this.quantity = MovieRentedOutBuilder.quantity;
    }

    public static String getMovieID() {
        return movieID;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class MovieRentedOutBuilder {
        private int quantity;
        private String movieID;

        public MovieRentedOut.MovieRentedOutBuilder setMovieID(String movieID) {
            this.movieID = movieID;
            return this;
        }

        public MovieRentedOut.MovieRentedOutBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public MovieRentedOut build() {
            return new MovieRentedOut(this);
        }
        public MovieRentedOutBuilder copy(MovieRentedOut MovieRentedOut)
        {
            this.movieID = MovieRentedOut.movieID;
            this.quantity = MovieRentedOut.quantity;

            return this;
        }

        @Override
        public String toString() {
            return "MovieRentedOut{" +
                    "movieID=" + movieID +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
