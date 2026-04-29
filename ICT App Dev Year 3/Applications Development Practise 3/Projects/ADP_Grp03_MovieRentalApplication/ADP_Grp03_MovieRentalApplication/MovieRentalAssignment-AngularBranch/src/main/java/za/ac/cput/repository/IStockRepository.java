package za.ac.cput.repository;

/*
    IStockRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/


import za.ac.cput.entity.Stock;

import java.util.Set;

public interface IStockRepository extends IRepository<Stock, String> {
    public Set<Stock> getAll();
}