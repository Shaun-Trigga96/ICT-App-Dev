/*
 * Seat.java
 * Entity for the Seat.
 * Author: Nikiwe Mkontshwana. (2142367141)
 * Due Date: 11 June 2021....
 * */
package za.ac.cput.ADP3LabBookingSystem.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.ADP3LabBookingSystem.Entity.Seat;

import static org.junit.jupiter.api.Assertions.*;

class SeatFactoryTest {
    @Test
    public void createSeat(){
        Seat seat = SeatFactory.createSeat("4","yes",true);
        System.out.println(seat);
    }

}