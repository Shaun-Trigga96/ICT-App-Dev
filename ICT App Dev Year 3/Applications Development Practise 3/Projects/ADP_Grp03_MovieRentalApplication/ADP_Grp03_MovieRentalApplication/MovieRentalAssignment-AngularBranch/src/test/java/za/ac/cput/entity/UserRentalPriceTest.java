package za.ac.cput.entity;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.junit.jupiter.api.*;
import za.ac.cput.factory.UserRentalPriceFactory;
import static org.junit.jupiter.api.Assertions.*;

public class UserRentalPriceTest {

    UserRentalPrice userRentalPrice_1, userRentalPrice_2, userRentalPrice_3;

    @BeforeEach
    void setUp ()
    {
        userRentalPrice_1 = UserRentalPriceFactory.build(5,10.00);
        userRentalPrice_2 = UserRentalPriceFactory.build(8,26.00);
        userRentalPrice_3 = userRentalPrice_1;
    }

    @Test
    void testEqualty()
    {
        assertEquals(userRentalPrice_1,userRentalPrice_3);
    }

    @Test
    void testIdentity()
    {
        assertSame(userRentalPrice_1,userRentalPrice_3);
    }

    @Disabled
    @Test
    void disabledTest()
    {
        assertSame(userRentalPrice_3,userRentalPrice_2);
    }

    @Timeout(10)
    @Test
    void timeoutTest()
    {
        assertNotNull(userRentalPrice_3);
    }
}
