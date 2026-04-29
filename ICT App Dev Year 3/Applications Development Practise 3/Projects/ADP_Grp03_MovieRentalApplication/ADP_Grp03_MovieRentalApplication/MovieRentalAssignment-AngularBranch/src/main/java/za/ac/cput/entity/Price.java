package za.ac.cput.entity;

/*
    Price.java
    Entity for the Price
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Price implements Serializable {
    private float amount;
    @Id private String movieId;

    protected Price(){
    }

    private Price(PriceBuilder PriceBuilder){
        this.amount=PriceBuilder.amount;
        this.movieId=PriceBuilder.movieId;
    }

    public static class PriceBuilder{
        private float amount;
        private String movieId;

        public PriceBuilder setAmount(float amount) {
            this.amount = amount;
            return this;
        }

        public PriceBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }
        public PriceBuilder copy(Price price){
            this.movieId=price.movieId;
            this.amount=price.amount;
            return this;
        }
        public Price build(){
            return new Price(this);
        }
    }

    public String getMovieId() {
        return movieId;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                '}';
    }
}
