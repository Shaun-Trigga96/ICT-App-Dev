package za.ac.cput.entity;

/*
    RatingTest.java
    Test Class for the Rating entity
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.RatingFactory;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    Rating rating1, rating2, rating3, rating4;

    @BeforeEach
    void setUp(){
        rating1 = RatingFactory.build(8.3);
        rating2 = RatingFactory.build(9.3);
        rating3 = RatingFactory.build(7.2);
        rating4 = rating1;
    }

    @Test
    void testObjectEquality(){
        assertEquals(rating1, rating4);
    }

    @Test
    void testObjectIdentity(){
        assertSame(rating1, rating4);
    }

    @Timeout(15)
    @Test
    void usingTimeout(){
        assertNotNull(rating1);
    }

    @Disabled
    @Test
    void disabledTest(){
        assertSame(rating1, rating3);
    }
}