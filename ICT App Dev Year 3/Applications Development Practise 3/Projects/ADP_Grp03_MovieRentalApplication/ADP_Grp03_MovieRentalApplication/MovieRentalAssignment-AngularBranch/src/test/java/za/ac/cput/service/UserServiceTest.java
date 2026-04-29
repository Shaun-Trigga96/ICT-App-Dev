/*
package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {
    private static UserService service = UserService.getService();
    private static User user = UserFactory.build("boy" , 11, 7856, "Yaasin", "Cole");

    @Test
    void Create()
    {
        User built =service.create(user);

        assertEquals(built.getUserId() , user.getUserId());
        System.out.println("Create :"+ built);

    }
    @Test
    void Read()
    {
        User read = service.read(user.getUserId());

        System.out.println("Read: " + read);
    }
    @Test
    void Update()
    {
        User updated = new User.userBuilder().copy(user).setFirstName("John").setLastName("Snow").setUserId("100").setAddressId(756).setIdNumber(94).build();
        System.out.println("Updated: " + updated);


    }
    @Test
    void Delete()
    {
        boolean success =service.delete(user.getUserId());
        assertTrue(success);
        System.out.println("Deleted : "+ success);

    }

    @Test
    @Order(5)
    void getAll()
    {
        System.out.println("Show All : ");
        System.out.println(service.getAll());

    }

}*/
