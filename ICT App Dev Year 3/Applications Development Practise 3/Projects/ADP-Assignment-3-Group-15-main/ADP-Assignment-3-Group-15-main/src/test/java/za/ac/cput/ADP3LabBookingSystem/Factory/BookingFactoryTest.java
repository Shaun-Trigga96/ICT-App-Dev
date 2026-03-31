/*
   BookingFactoryTest.java
   Booking Factory Test
   Author: AJ Mitchell 219024979
   Date: 10 June
*/

package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;

import java.util.Date;

class BookingFactoryTest {

    @Test
    public static void demo(){
        BookingFactory bf = new BookingFactory();
        System.out.println(bf.createBooking("219024979", new Date("17 July 2021"), "09.00 - 10.00", "09.00 - 10.00", "Lab B", "1b"));


    }


}