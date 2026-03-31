package za.ac.cput.ADP3LabBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ADP3LabBookingSystem.Entity.Booking;
import za.ac.cput.ADP3LabBookingSystem.Repository.IBookingRepository;
import java.util.HashSet;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}

