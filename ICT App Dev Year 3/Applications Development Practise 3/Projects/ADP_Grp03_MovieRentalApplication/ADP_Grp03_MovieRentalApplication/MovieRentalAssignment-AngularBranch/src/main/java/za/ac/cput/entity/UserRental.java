package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */
@Entity
public class UserRental {
    @Id
    private String rentalId;
    private String userId, movieId;
    private String rentalDate;
    private String returnDate;

    public UserRental(){
    }

    public UserRental(UserRentalBuilder userRentalBuilder){
        this.rentalId = userRentalBuilder.rentalId;
        this.userId = userRentalBuilder.userId;
        this.movieId = userRentalBuilder.movieId;
        this.rentalDate = userRentalBuilder.rentalDate;
        this.returnDate = userRentalBuilder.returnDate;

    }

    public String getUserId() {
        return userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getRentalId() {
        return rentalId;
    }

    public static class UserRentalBuilder{
        private String rentalId;
        private String userId;
        private String movieId;
        private String rentalDate;
        private String returnDate;

        public UserRentalBuilder setRentalId(String rentalId) {
            this.rentalId = rentalId;
            return this;
        }

        public UserRentalBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserRentalBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public UserRentalBuilder setRentalDate(String rentalDate) {
            this.rentalDate = rentalDate;
            return this;
        }

        public UserRentalBuilder setReturnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public UserRentalBuilder copy (UserRental userRental) {
            this.movieId = userRental.movieId;
            this.rentalDate = userRental.rentalDate;
            this.rentalId = userRental.rentalId;
            this.returnDate = userRental.returnDate;
            this.userId = userRental.userId;

            return this;
        }

        public UserRental build(){
            return new UserRental(this);
        }
    }

    @Override
    public String toString() {
        return "UserRental{" +
                "rentalId='" + rentalId + '\'' +
                ", userId='" + userId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", rentalDate='" + rentalDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
