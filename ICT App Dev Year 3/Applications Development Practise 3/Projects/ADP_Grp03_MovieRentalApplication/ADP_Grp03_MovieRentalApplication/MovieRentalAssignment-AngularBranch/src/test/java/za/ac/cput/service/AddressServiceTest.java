/*
package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AddressServiceTest {

    private static IAddressService service = AddressService.getService();
    private static Address address = AddressFactory.build("roseMary", "Cape Town", "South Africa"
            ,"Western Cape",7801 , "68597");

    @Test
    void Create()
    {
        Address built =service.create(address);

        assertEquals(built.getUserId() , address.getUserId());
        System.out.println("Create :"+ built);

    }
    @Test
    void Read()
    {
        Address read = service.read(address.getUserId());

        System.out.println("Read: " + read);

    }
    @Test
    void Update()
    {
        Address updated = new Address.addressBuilder().copy(address).setCity("Durban").setCountry("Sweden")
                .setPostalCode(1111).setProvince("Random").setuserId("8000")
                .setStreet("denmarkstreet").build();
        System.out.println("Updated: " + updated);


    }
    @Test
    void Delete()
    {
        boolean success =service.delete(address.getUserId());
        assertTrue(success);
        System.out.println("Deleted : "+ success);

    }

    @Test
    void getAll()
    {
        System.out.println("Show All : ");
        System.out.println(service.getAll());

    }
}*/
