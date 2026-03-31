package za.ac.cput.ADP3LabBookingSystem.Service;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;
import za.ac.cput.ADP3LabBookingSystem.Factory.AddressFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    private static Address address  = AddressFactory.createAddress("12th","Stelly", "Seenberg", 1233);


    @Test
    void a_create() {
        Address createdAddress = addressService.create(address);
        assertNotNull(createdAddress);
        System.out.println("Created...");
        System.out.println("Address: " + createdAddress);
    }

    @Test
    void b_read() {
        Address readAddress = addressService.read(Integer.toString(address.getZipCode()));
        assertNotNull(readAddress);
        System.out.println("Read...");
        System.out.println("Address: " + readAddress);
    }

    @Test
    void c_update() {
        Address oldAddress  = addressService.read(Integer.toString(address.getZipCode()));
        Address updatedAddress = new Address.Builder().copy(oldAddress).setCity("Stelly").build();
        assertNotNull(addressService.update(updatedAddress));
        System.out.println("Updated...");
        System.out.println("Address: " + updatedAddress);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean isDeleted = addressService.delete(Integer.toString(1233));
        assertTrue(isDeleted);
        System.out.println("Deleted: " + isDeleted);
    }

    @Test
    void d_getAll() {
        List<Address> addressList = addressService.getAll();
        addressList.forEach( address -> System.out.println("Address: " + address));
    }

}
