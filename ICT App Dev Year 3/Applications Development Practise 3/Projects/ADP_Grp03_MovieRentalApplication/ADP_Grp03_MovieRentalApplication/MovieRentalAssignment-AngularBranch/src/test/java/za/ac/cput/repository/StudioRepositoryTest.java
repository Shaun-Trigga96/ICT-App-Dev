//package za.ac.cput.repository;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.MovieGenre;
//import za.ac.cput.entity.Studio;
//import za.ac.cput.factory.MovieGenreFactory;
//import za.ac.cput.factory.StudioFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///* Studio.java
//        studio repo
//        Author: Marchello Carolus 218234457
//        Date: 26 July 2021
//        */
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class StudioRepositoryTest {
//
//    private static StudioRepository repository = StudioRepository.getRepository();
//    private static Studio studio = StudioFactory.build("1234", "Sony");
//
//    @Test
//    void a_create() {
//        Studio create = repository.create(studio);
//        assertEquals(create.toString(), studio.toString());
//        System.out.println("Create: " + create);
//    }
//
//    @Test
//    void b_read() {
//        Studio read = repository.read(studio.getStudioId());
//        //assertEquals(1234, read.getStudioId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        Studio update = new Studio.Builder().copy(studio).setStudioId("2342").build();
//        System.out.println("Update: " + update);
//    }
//
//    @Test
//    void d_delete() {
//        repository.delete(studio.getStudioId());
//
//        System.out.println(studio.getStudioId() + " was deleted.");
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Get All: " + repository.getAll());
//    }
//}