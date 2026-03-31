package za.ac.cput.repository;

/*
    IRatingRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/

import za.ac.cput.entity.Rating;

import java.util.Set;

public interface IRatingRepository extends IRepository<Rating, String> {
    public Set<Rating> getAll();
}
