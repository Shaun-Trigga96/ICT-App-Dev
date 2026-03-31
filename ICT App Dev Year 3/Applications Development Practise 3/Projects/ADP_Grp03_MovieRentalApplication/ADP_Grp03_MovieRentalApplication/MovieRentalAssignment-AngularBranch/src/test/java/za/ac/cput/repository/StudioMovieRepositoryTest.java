//package za.ac.cput.repository;
///**
// * Author: Emilio Castano
// * Student Number: 219035709
// *
// */
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.StudioMovie;
//import za.ac.cput.factory.StudioMovieFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//
//public  class StudioMovieRepositoryTest {
//    private static StudioMovieRepository repository = StudioMovieRepository.getRepository();
//    private static StudioMovie studioMovie = StudioMovieFactory.build("23", "34567");
//
//
//    @Test
//    void a_create() {
//        StudioMovie created = repository.create(studioMovie);
//        assertEquals(studioMovie.getStudioId(), created.getStudioId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void b_read() {
//        StudioMovie read = repository.read(studioMovie.getStudioId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        StudioMovie updated = new StudioMovie.studioBuilder().copy(studioMovie).setStudioId("2333").build();
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_delete() {
//        repository.delete(studioMovie.getStudioId());
//        System.out.println("Deleted: " + studioMovie.getStudioId() + "");
//
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show All: ");
//        System.out.println(repository.getAll());
//    }
//}