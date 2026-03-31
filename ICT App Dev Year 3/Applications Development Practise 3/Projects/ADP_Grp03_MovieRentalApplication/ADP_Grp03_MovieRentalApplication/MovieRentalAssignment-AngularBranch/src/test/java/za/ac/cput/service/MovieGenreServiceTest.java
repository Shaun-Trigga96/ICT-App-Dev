//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.MovieGenre;
//import za.ac.cput.factory.MovieGenreFactory;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//// Author: Marchello Carolus 218234457

//@TestMethodOrder(MethodOrderer.MethodName.class)
//class MovieGenreServiceTest {
//
//    private static MovieGenreService service = MovieGenreService.getService();
//    private static MovieGenre genre = MovieGenreFactory.build("2342", "00000");
//
//    @Test
//    void a_create() {
//        MovieGenre create = service.create(genre);
//        assertEquals(create.getGenreId(), create.getGenreId());
//        System.out.println("Create: " +create);
//    }
//
//    @Test
//    void b_read() {
//        MovieGenre read = service.read(genre.getGenreId());
//        assertNotNull(read);
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update() {
//        MovieGenre update = new MovieGenre.Builder().copy(genre).setGenreId("2021").build();
//        System.out.println("updated : "+ update);
//    }
//
//    @Test
//    void d_delete() {
//        boolean succ = service.delete(genre.getGenreId());
//        assertTrue(succ);
//        System.out.println("Delete: " + succ);
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println(service.getAll());
//    }
//}