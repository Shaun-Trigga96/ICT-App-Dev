package za.ac.cput.entity;
/**
 * Author: Emilio Castano
 * Student Number: 219035709
 *
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.StudioMovieFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

class StudioMovieTest {
    StudioMovie studioMovie1, studioMovie2, studioMovie3;

    @BeforeEach
    void setUp(){
        studioMovie1 = StudioMovieFactory.build("32", "23456");
        studioMovie2 = StudioMovieFactory.build("20","36786");
        studioMovie3 = studioMovie1;
    }

    @Test
    void testObjectEquality(){ assertEquals(studioMovie1, studioMovie3);}

    @Test
    void testObjectIdentity(){assertSame(studioMovie1, studioMovie3);}

    @Timeout(20)
    @Test
    void usingTimeout(){assertNotNull(studioMovie2);}

    @Disabled
    @Test
    void  disabledTest(){assertSame(studioMovie1, studioMovie3);}





}