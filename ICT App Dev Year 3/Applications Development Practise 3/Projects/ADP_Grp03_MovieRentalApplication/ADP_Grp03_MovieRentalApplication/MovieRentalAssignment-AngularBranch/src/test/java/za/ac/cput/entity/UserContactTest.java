package za.ac.cput.entity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.factory.UserContactFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

/* UserContactTest.java
 Test for the UserContact
 Author: Malcolm Camelo (217137334)
 Date: 10 June 2021
*/

class UserContactTest {


    @Test
    void test() {
        UserContact uc = UserContactFactory.build("021782567");
        System.out.println(uc);


    }

    @Test
    void test2Equal() {
        UserContact uc = UserContactFactory.build("021782567");
        UserContact uc2 = UserContactFactory.build("021782567");
        assertNotEquals(uc, uc2);
    }

    @Test
    void test3Identity() {
        UserContact uc = UserContactFactory.build("021782567");
        assertSame(uc, uc);
    }

    @Timeout(value = 1, unit = MILLISECONDS)
    void test4TimeOut() {
        for (int i = 0; i < 100; i++) {
            UserContact uc = UserContactFactory.build("021782567");
            System.out.println(uc);
        }
    }

    @Disabled
    void test5Disable() {
        int v = 2;
        int i = 1;
        assertSame(i, v);
    }
}