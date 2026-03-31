//package za.ac.cput.service;
//
//
///* ContactType.java
// Entity for the ContactType
// Author: Malcolm Camelo (217137334)
// Date: 22 August 2021
//*/
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestMethodOrder;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import za.ac.cput.entity.UserContact;
//import za.ac.cput.factory.UserContactFactory;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class UserContactServiceTest {
//    private static IUserContactService service = UserContactService.getService();
//    private static UserContact userContact= UserContactFactory.build("3333");
//
//
//
//    @Test
//    void a_create() {
//        UserContact created=service.create(userContact);
//        System.out.println(userContact);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read() {
//        UserContact read=service.read(String.valueOf(userContact.getUserId()));
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update() {
//        UserContact updated=new UserContact.userContactBuilder().copy(userContact).setContact("12345678").build();
//        System.out.println(updated);
//        assertNotNull(updated);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success=service.delete(String.valueOf(userContact.getUserId()));
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show All:");
//        System.out.println(service.getAll());
//    }
//}