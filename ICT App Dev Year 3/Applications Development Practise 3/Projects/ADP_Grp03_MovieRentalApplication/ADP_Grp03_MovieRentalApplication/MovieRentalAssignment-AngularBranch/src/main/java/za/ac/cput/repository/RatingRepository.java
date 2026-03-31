package za.ac.cput.repository;

/*
    RatingRepository.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Repository
    26 July 2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
}