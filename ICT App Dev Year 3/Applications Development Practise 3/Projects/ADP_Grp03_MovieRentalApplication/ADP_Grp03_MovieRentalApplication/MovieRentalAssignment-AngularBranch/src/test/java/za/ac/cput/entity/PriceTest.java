package za.ac.cput.entity;

/*
    PriceTest.java
    Test Class for the Price entity
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
    11 June 2021
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.PriceFactory;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    Price price1,price2,price3,price4;

    @BeforeEach
    void setUp(){
        price1 = PriceFactory.build(50.0f);
        price2 = PriceFactory.build(50.0f);
        price3 = PriceFactory.build(60.00f);
        price4 = price1;
    }

    @Test
    void testObjectEquality(){
        assertEquals(price1,price4);
    }

    @Test
    void testObjectIdentity(){
        assertSame(price1,price4);
    }

    @Timeout(15)
    @Test
    void usingTimeout(){
        assertNotNull(price1);
    }

    @Disabled
    @Test
    void disabledTest(){
        assertSame(price1,price3);
    }
}