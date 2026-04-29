/*
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Address;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class RoleRepositoryTest {
    private static RoleRepository repository = RoleRepository.getRepository();
    private static Role role = RoleFactory.build("452" , "Yaasin", "Admin");

    @Test
    @Order(1)
    void Create()
    {
        Role built =repository.create(role);

        assertEquals(built.getRoleId() , role.getRoleId());
        System.out.println("Create :"+ built);

    }
    @Test
    @Order(2)
    void Read()
    {
        Role read = repository.read(role.getRoleId());

        System.out.println("Read : " + read);

    }
    @Test
    @Order(3)
    void Update()
    {
        Role updated = new Role.roleBuilder().copy(role).setRoleId("4523").setName("John").setDescription("User").build();

        System.out.println("updated : "+ updated);


    }
    @Test
    @Order(4)
    void Delete()
    {
        boolean success =repository.delete(role.getRoleId());
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
