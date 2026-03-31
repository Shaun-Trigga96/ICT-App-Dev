/*
   BookingFactory.java
   Booking Factory
   Author: AJ Mitchell 219024979
   Date: 10 June
*/
package za.ac.cput.ADP3LabBookingSystem.Factory;

import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Util.GenericHelper;

import java.util.Date;
import java.sql.Time;

public class BookingFactory {

    public static Booking createBooking(String studentnr, Date bookingdate, String starttime, String endtime, String labid,String seatnumber) {

        String bookingId = GenericHelper.getAlphaNumericString(6);
        Booking booking = null;

        if(studentnr.length() > 9 || studentnr.length() < 9) {

            System.out.println("Invalid Student Number.");
            return booking;

        } else booking = new Booking.Builder().setBookingId(bookingId).setStudentNr(studentnr).setBookingDate(bookingdate).setStartTime(starttime).setEndTime(endtime).setLabId(labid).setSeatNumber(seatnumber).build();

        return booking;
    }

}