//package za.ac.cput.service;
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
//import za.ac.cput.entity.ContactType;
//import za.ac.cput.factory.ContactTypeFactory;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//
//
//
//class ContactTypeServiceTest {
//    private static IContactTypeService service = ContactTypeService.getService();
//    private static ContactType contactType= ContactTypeFactory.build("work","available 9am to 5am");
//    @Test
//    void a_create() {
//        ContactType created=service.create(contactType);
//        System.out.println(contactType);
//        assertNotNull(created);
//
//    }
//
//    @Test
//    void b_read() {
//        ContactType read=service.read(String.valueOf(contactType.getContactTypeId()));
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update() {
//        ContactType updated=new ContactType.contactTypeBuilder().copy(contactType).setName("House number").build();
//        System.out.println(updated);
//        assertNotNull(updated);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success=service.delete(String.valueOf(contactType.getContactTypeId()));
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show All:");
//        System.out.println(service.getAll());
//    }
//
//
//
//}