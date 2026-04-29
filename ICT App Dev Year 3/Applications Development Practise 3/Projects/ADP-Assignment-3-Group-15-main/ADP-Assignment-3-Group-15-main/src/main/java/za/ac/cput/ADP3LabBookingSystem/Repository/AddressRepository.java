package za.ac.cput.ADP3LabBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
