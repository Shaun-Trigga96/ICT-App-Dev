package za.ac.cput.entity;

/*
    StockTest.java
    Test Class for the Stock entity
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.StockFactory;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    Stock stock1, stock2, stock3, stock4;

    @BeforeEach
    void setUp(){
        stock1 = StockFactory.build(4);
        stock2 = StockFactory.build(9);
        stock3 = StockFactory.build(7);
        stock4 = stock1;
    }

    @Test
    void testObjectEquality(){
        assertEquals(stock1, stock4);
    }

    @Test
    void testObjectIdentity(){
        assertSame(stock1, stock4);
    }

    @Timeout(15)
    @Test
    void usingTimeout(){
        assertNotNull(stock1);
    }

    @Disabled
    @Test
    void disabledTest(){
        assertSame(stock1, stock3);
    }
}