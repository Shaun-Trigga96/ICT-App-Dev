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
import za.ac.cput.factory.GenreFactory;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {
    Genre genre1, genre2, genre3, genre4;

    @BeforeEach
    void setUp(){
        genre1 = GenreFactory.build("ADV","Adventure", "Enjoy adventures movie, with action and fiction");
        genre2 = GenreFactory.build("ACT","Action", "Action pact movies with guns and crazy stunts");
        genre3 = GenreFactory.build("HOR", "Horror","These horrors will give you sleepless nights and and scream like never before");
        genre4 = genre2;
    }

    @Test
    void testObjectEquality(){ assertEquals(genre2, genre4);}

    @Test
    void testObjectIdentity(){assertSame(genre2, genre4);}

    @Timeout(20)
    @Test
    void usingTimeout(){assertNotNull(genre2);}

    @Disabled
    @Test
    void  disabledTest(){assertSame(genre1, genre3);}

    }

