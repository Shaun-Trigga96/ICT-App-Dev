/*
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRepositoryTest {

    private static UserRepository repository = UserRepository.getRepository();
    private static User user = UserFactory.build("7856", 756, 101,"boy" , "Cole");

    @Test
    @Order(1)
    void Create()
    {
        User built =repository.create(user);

        assertEquals(built.getUserId() , user.getUserId());
        System.out.println("Create :"+ built);

    }
    @Test
    @Order(2)
    void Read()
    {
        User read = repository.read(user.getUserId());

        System.out.println("Read : " + read);

    }
    @Test
    @Order(3)
    void Update()
    {
        User updated = new User.userBuilder().copy(user).setFirstName("John").setLastName("Snow").setUserId("100").setAddressId(756).setIdNumber(94).build();

        System.out.println("updated : "+ updated);


    }
    @Test
    @Order(4)
    void Delete()
    {
        boolean success =repository.delete(user.getUserId());
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
