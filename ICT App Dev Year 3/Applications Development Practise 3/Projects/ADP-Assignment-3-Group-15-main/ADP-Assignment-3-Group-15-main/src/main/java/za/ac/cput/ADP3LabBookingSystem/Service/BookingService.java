package za.ac.cput.ADP3LabBookingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Repository.BookingRepository;

import java.util.List;
import java.util.Set;

@Service
public class BookingService implements IBookingService{
    private static BookingService service = null;

    @Autowired
    private BookingRepository repository;

    //
    public static BookingService getService(){
        if(service == null){
            service = new BookingService();
        }
        return service;
    }

    @Override
    public Booking create(Booking booking) {

        return this.repository.save(booking);
    }

    @Override
    public Booking read(String bookingId) {
        return this.repository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {

        if(this.repository.existsById(booking.getBookingId()))
            return  this.repository.save(booking);

        return null;
    }

    @Override
    public boolean delete(String bookingId) {

        this.repository.deleteById(bookingId);
        if(this.repository.existsById(bookingId))
            return false;

        else return true;
    }

    @Override
    public List<Booking> getAll() {
        return this.repository.findAll();
    }
}

