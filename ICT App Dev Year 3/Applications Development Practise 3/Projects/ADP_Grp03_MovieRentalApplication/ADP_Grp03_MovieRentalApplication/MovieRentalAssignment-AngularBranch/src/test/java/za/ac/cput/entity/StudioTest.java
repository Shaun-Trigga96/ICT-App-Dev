package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import za.ac.cput.factory.StudioFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudioTest {
    Studio studio1, studio2, studio3, studio4;

    @BeforeEach
    void setUp(){
        studio1 = StudioFactory.build("1234","Sony");
        studio2 = StudioFactory.build("4321","Marvel");
        studio3 = StudioFactory.build("0000","Yes");
        studio4 = studio1;
    }

    @Test
    void testObjectEquality(){
        assertEquals(studio1, studio4);
    }

    @Test
    void testObjectIdentity(){
        assertSame(studio1, studio4);
    }

    @Timeout(15)
    @Test
    void usingTimeout(){
        assertNotNull(studio1);
    }

    @Disabled
    @Test
    void disabledTest(){
        assertSame(studio1, studio3);
    }

}