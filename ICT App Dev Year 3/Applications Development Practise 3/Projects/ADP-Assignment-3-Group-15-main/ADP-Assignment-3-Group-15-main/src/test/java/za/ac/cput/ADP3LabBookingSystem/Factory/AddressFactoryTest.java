/*
  AddressFactoryTest.java
  Test Class
  Author: Felecia Zweni(218330189)
  Date: 10 June 2021
 */

package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;

import static org.junit.jupiter.api.Assertions.*;

public class AddressFactoryTest {


    public Address address1, address2;

    @BeforeEach
    void setUp(){
        address1 = new Address();
        address2 = new Address();
    }

    @Test
    public void createAddress(){
        Address address = AddressFactory.createAddress("Bassi Road", "Cape Town", "Zonnebloem", 7234);
        System.out.println(address);
    }

    @Test

    void testIdentity(){
        assertSame(address1,address2);
    }

    @Test

    void testEquality(){
        assertEquals(address1, address2);

    }


    @Test

    void testTimeout(){
        new Address();
    }

    @Test
    @Disabled
    void testDisabled(){
        fail("This is not going to fail");
    }
}

