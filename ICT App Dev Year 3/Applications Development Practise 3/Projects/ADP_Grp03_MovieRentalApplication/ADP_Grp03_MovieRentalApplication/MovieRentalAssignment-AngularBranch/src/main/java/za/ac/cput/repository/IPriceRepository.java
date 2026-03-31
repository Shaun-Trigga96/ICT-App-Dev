package za.ac.cput.repository;

/*
    IPriceRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/

import za.ac.cput.entity.Price;

import java.util.Set;

public interface IPriceRepository extends IRepository<Price, String> {
    public Set<Price> getAll();
}
