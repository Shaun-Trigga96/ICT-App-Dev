//package za.ac.cput.repository;
//
///* ContactType.java
// Entity for the ContactType
// Author: Malcolm Camelo (217137334)
// Date: 25 June 2021
//*/
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//
//
//import za.ac.cput.entity.UserContact;
//import za.ac.cput.factory.UserContactFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//public class UserContactRepositoryTest {
//    private static UserContactRepository repository = UserContactRepository.getRepository();
//    private static UserContact userContact = UserContactFactory.build("535435@gmail.com");
//
//
//
//    @Test
//    void a_create() {
//        UserContact created = repository.create(userContact);
//        assertEquals(created.toString(), userContact.toString());
//        System.out.println("create:" +created);
//    }
//    @Test
//    void b_read() {
//        UserContact read = repository.read(String.valueOf(userContact.getUserId()));
//        assertNotNull(read);
//        System.out.println("read: "+read);
//
//    }
//
//
//    @Test
//    void c_update() {
//        UserContact contactUpdate = new UserContact.userContactBuilder().copy(userContact).setContact("1111234@gmail.com").build();
//        assertNotNull(repository.update(contactUpdate));
//        System.out.println("update: "+contactUpdate);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success =repository.delete(String.valueOf(userContact.getUserId()));
//        assertTrue(success);
//        System.out.println("deleted: "+success);
//    }
//
//
//    @Test
//    void e_getAll() {
//        System.out.println("Number of User contacts : "+repository.getAll());
//    }
//}
