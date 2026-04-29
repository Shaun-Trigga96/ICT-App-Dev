package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.MovieGenre;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/* MovieGenre.java

        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */

class MovieGenreFactoryTest {
        MovieGenre m;
        MovieGenre m1;

    @BeforeEach
    void setUp() {
         m =  new MovieGenreFactory().build("3214","345434"); /*createMovieGenre  */
         m1 = m;

}

    //Object Identity
    @Test
    void testIdentity(){
        assertSame(m, m1);
    }

    //Object Equality
    @Test
    void testEquality(){
        assertEquals(m, m1);
    }

    //Disabling Test
    @Disabled
    @Test
    void disableTest(){
        assertSame(m, m1);
    }

    //Timeouts
    @Test
    @Timeout(10)
    void timeoutMethod(){
        for(int i = 0; i < 20; i++){
            System.out.println(i);

        };


    }

}