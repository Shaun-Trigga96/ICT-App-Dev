package za.ac.cput.entity;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.factory.UserRentalFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserRentalTest {

    UserRental userRental_1, userRental_2, userRental_3;

    @BeforeEach
    void setUp()
    {
        userRental_1 = UserRentalFactory.build("15","154");
        userRental_2 = UserRentalFactory.build("23","191");
        userRental_3 = userRental_1;
    }

    @Test
    void testEqualty()
    {
        assertEquals(userRental_1, userRental_3);
    }

    @Test
    void testIdentity()
    {
        assertSame(userRental_1, userRental_3);
    }

    @Disabled
    @Test
    void disabledTest()
    {
        assertSame(userRental_3,userRental_2);
    }

    @Timeout(10)
    @Test
    void timeoutTest()
    {
        assertNotNull(userRental_1);
    }
}
