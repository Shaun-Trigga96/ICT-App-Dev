package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Studio;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/* MovieGenre.java

        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */

class StudioFactoryTest {

    Studio s;
    Studio s1;

    @BeforeEach
    void setUp() {
        s =  new StudioFactory().build("3214","Sony");
        s1 = s;

    }

    //Object Identity
    @Test
    void testIdentity(){
        assertSame(s, s1);
    }

    //Object Equality
    @Test
    void testEquality(){
        assertEquals(s, s1);
    }

    //Disabling Test
    @Disabled
    @Test
    void disableTest(){
        assertSame(s, s1);
    }

    //Timeouts
    @Test
    @Timeout(10)
    void timeoutMethod(){
        for(int j = 1; j <=20; j++){
            System.out.println(j);

        };


    }
}