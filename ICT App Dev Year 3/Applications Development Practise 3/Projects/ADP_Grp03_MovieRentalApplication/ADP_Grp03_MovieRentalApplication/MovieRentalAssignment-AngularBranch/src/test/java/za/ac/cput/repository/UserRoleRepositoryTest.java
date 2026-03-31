/*
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.userRole;
import za.ac.cput.factory.UserRoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRoleRepositoryTest {

    private static UserRoleRepository repository = UserRoleRepository.getRepository();
    private static userRole userrole = UserRoleFactory.build("452" , 852);

    @Test
    @Order(1)
    void Create()
    {
        userRole built =repository.create(userrole);

        assertEquals(built.getUserId() , userrole.getUserId());
        System.out.println("Create :"+ built);

    }
    @Test
    @Order(2)
    void Read()
    {
        userRole read = repository.read(userrole.getUserId());

        System.out.println("Read : " + read);

    }
    @Test
    @Order(3)
    void Update()
    {
        userRole updated = new userRole.userRoleBuilder().copy(userrole).setUserId("100").setRoleId(400).build();


        System.out.println("updated : "+ updated);


    }
    @Test
    @Order(4)
    void Delete()
    {
        boolean success =repository.delete(userrole.getUserId());
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
