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
//import za.ac.cput.entity.ContactType;
//import za.ac.cput.factory.ContactTypeFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//public class ContactTypeRepositoryTest {
//private static ContactTypeRepository repository = ContactTypeRepository.getRepository();
//private static ContactType contactType = ContactTypeFactory.build("House", "Home number");
//
//
//
//    @Test
//    void e_getAll() {
//        System.out.println("Number of contacts type: "+repository.getAll());
//    }
//
//    @Test
//    void a_create() {
//        ContactType created = repository.create(contactType);
//        assertEquals(created.toString(), contactType.toString());
//        System.out.println("create:" +created);
//    }
//
//    @Test
//    void b_read() {
//        ContactType read = repository.read(String.valueOf(contactType.getContactTypeId()));
//        assertNotNull(read);
//        System.out.println("read: "+read);
//
//    }
//
//    @Test
//    void c_update() {
//        ContactType contactUpdate = new ContactType.contactTypeBuilder().copy(contactType).setName("House number").build();
//        assertNotNull(repository.update(contactUpdate));
//        System.out.println("update: "+contactUpdate);
//    }
//
//    @Test
//    void d_delete() {
//        boolean success =repository.delete(String.valueOf(contactType.getContactTypeId()));
//        assertTrue(success);
//        System.out.println("deleted: "+success);
//    }
//}
