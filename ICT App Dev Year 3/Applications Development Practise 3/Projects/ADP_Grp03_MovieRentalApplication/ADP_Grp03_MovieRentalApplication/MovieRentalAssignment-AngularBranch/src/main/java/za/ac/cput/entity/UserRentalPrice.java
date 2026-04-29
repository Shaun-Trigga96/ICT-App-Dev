package za.ac.cput.entity;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserRentalPrice {
    @Id
    private String rentalId;
    private int duration;
    private double amount;

    public UserRentalPrice(){

    }

    public UserRentalPrice(UserRentalPriceBuilder userRentalPriceBuilder){
        this.rentalId = userRentalPriceBuilder.rentalId;
        this.duration = userRentalPriceBuilder.duration;
        this.amount = userRentalPriceBuilder.amount;
    }

    public int getDuration() {
        return duration;
    }

    public double getAmount() {
        return amount;
    }

    public String getRentalId() {
        return rentalId;
    }

    public static class UserRentalPriceBuilder{
        private int  duration;
        private double amount;
        private String rentalId;

        public UserRentalPriceBuilder setRentalId(String rentalId) {
            this.rentalId = rentalId;
            return this;
        }

        public UserRentalPriceBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public UserRentalPriceBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public UserRentalPriceBuilder copy (UserRentalPrice userRentalPrice) {
            this.rentalId = userRentalPrice.rentalId;
            this.amount = userRentalPrice.amount;
            this.duration = userRentalPrice.duration;

            return this;
        }

        public UserRentalPrice build(){return new UserRentalPrice(this);}
    }

    @Override
    public String toString() {
        return "UserRentalPrice{" +
                "rentalId=" + rentalId +
                ", duration=" + duration +
                ", amount=" + amount +
                '}';
    }
}
