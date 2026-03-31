package za.ac.cput.ADP3LabBookingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Factory.BookingFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.BookingService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking){

        Booking newBooking = BookingFactory.createBooking(booking.getStudentnr(), booking.getBookingDate(), booking.getBookingStartTime(), booking.getBookingEndTime(), booking.getBookingLabId(), booking.getBookingSeatNumber());
        return bookingService.create(newBooking);
    }

    @GetMapping("/read{id}")
    public Booking read(@PathVariable String bookingId){
        return bookingService.read(bookingId);
    }


    @PostMapping("/update")
    public Booking update(@RequestBody Booking movie){ return bookingService.update(movie); }


    @PostMapping("/delete{id}")
    public boolean delete(@PathVariable String bookingId){
        return bookingService.delete(bookingId);
    }


    @GetMapping("/getAll")
    public List<Booking> getAll(){
        return bookingService.getAll();
    }
}
