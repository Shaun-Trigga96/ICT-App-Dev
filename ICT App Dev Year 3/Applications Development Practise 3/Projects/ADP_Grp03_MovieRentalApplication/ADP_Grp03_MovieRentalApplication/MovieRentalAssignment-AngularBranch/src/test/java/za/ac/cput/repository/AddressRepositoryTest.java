/*
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class AddressRepositoryTest {

    private static AddressRepository repository = AddressRepository.getRepository();
    private static Address address = AddressFactory.build("roseMary", "Cape Town", "South Africa"
                                                            ,"Western Cape",7801 , "68597");

    @Test
    @Order(1)
    void Create()
    {
        Address built =repository.create(address);

        assertEquals(built.getUserId() , address.getUserId());
        System.out.println("Create :"+ built);

    }
    @Test
    @Order(2)
    void Read()
    {
        Address read = repository.read(address.getUserId());

        System.out.println("Read : " + read);

    }
    @Test
    @Order(3)
    void Update()
    {
        Address updated = new Address.addressBuilder().copy(address).setCity("Durban").setCountry("Sweden")
                .setPostalCode(1111).setProvince("Random").setuserId("8000")
                .setStreet("denmarkstreet").build();

        System.out.println("updated : "+ updated);


    }
    @Test
    @Order(4)
    void Delete()
    {
        boolean success =repository.delete(address.getUserId());
        assertTrue(success);
        System.out.println("Deleted : "+ success);

    }

    @Test
    @Order(5)
    void getAll()
    {
        System.out.println("Show All : ");
        System.out.println(repository.getAll());

    }
}*/
