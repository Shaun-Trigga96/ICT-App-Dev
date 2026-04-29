package za.ac.cput.repository;

/*
    StockRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,String> {
}
