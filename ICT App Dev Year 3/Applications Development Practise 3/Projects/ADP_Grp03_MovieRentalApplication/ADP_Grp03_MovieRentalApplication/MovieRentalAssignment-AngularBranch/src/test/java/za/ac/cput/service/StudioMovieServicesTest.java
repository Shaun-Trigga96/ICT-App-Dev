//package za.ac.cput.service;
///**
// * Author: Emilio Castano
// * Student Number: 219035709
// *
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.entity.StudioMovie;
//import za.ac.cput.factory.StudioMovieFactory;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest
//class StudioMovieServicesTest {
//    @Autowired
//    private StudioMovieServices service;
//
//    private static StudioMovie studioMovie = StudioMovieFactory.build("24", "34567");
//
//    @Test
//    void a_create() {
//        StudioMovie created = service.create(studioMovie);
//        assertEquals(studioMovie.getStudioId(),created.getStudioId());
//        System.out.println("Created" + created);
//    }
//
//    @Test
//    void b_read() {
//        StudioMovie read = service.read(studioMovie.getStudioId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        StudioMovie old = service.read("36");
//        StudioMovie updated = new StudioMovie.studioBuilder().copy(studioMovie).setStudioId("43").build();
//        assertNotNull(service.update(updated));
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_delete() {
//        service.delete(studioMovie.getMovieId());
//        System.out.println("Deleted: " + studioMovie.getStudioId() + "");
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show All:");
//        System.out.println(service.getAll());
//    }
//}