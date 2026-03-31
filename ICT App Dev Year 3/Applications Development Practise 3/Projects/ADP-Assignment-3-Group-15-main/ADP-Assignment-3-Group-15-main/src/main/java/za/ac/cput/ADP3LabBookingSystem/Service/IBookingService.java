package za.ac.cput.ADP3LabBookingSystem.Service;

import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;

import java.util.List;
import java.util.Set;

public interface IBookingService extends IService<Booking, String> {

    public List<Booking> getAll();
}