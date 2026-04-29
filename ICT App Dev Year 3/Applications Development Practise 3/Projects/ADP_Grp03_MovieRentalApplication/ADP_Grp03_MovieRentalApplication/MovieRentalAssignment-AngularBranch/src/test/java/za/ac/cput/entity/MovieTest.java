package za.ac.cput.entity;

/*
    MovieTest.java
    Test Class for the Movie entity
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.MovieFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

class MovieTest {
    Movie movie1, movie2, movie3, movie4;

    @BeforeEach
    void setUp(){
        movie1 = MovieFactory.build("Lord of the Rings","12 January 2018","action","studio","actors",20,1);
        movie2 = MovieFactory.build("Harry Potter","18 July 2018","action","studio","actors",20,1);
        movie3 = MovieFactory.build("Mission Possible","28 February 2018","action","studio","actors",20,1);
        movie4 = movie1;
    }

    @Test
    void testObjectEquality(){
        assertEquals(movie1, movie4);
    }

    @Test
    void testObjectIdentity(){
        assertSame(movie1, movie4);
    }

    @Timeout(15)
    @Test
    void usingTimeout(){
        assertNotNull(movie1);
    }

    @Disabled
    @Test
    void disabledTest(){
        assertSame(movie1, movie3);
    }
}