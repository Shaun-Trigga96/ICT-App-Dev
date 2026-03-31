package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/*
    Stock.java
    Entity for the Stock
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/
@Entity
public class Stock implements Serializable {

    @Id private String movieId;
    private int quantity;

    protected Stock(){

    }

    private Stock(StockBuilder StockBuilder) {
        this.movieId=StockBuilder.movieId;
        this.quantity=StockBuilder.quantity;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class StockBuilder {
        private String movieId;
        private int quantity;

        public StockBuilder setMovieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public StockBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Stock.StockBuilder copy(Stock stock){
            this.movieId=stock.movieId;
            this.quantity=stock.quantity;
            return this;
        }

        public Stock build(){
            return new Stock(this);
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "movieId=" + movieId +
                ", quantity=" + quantity +
                '}';
    }
}
