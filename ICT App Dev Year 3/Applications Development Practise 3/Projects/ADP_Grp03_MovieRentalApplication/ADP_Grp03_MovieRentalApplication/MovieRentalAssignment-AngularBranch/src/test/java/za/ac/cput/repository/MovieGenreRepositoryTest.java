//package za.ac.cput.repository;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.MovieGenre;
//import za.ac.cput.factory.MovieGenreFactory;
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
//class MovieGenreRepositoryTest {
//
//    private static MovieGenreRepository repo = MovieGenreRepository.getRepository();
//    private static MovieGenre genre = MovieGenreFactory.build("2342", "00000");
//
//    @Test
//    void a_create() {
//        MovieGenre create = repo.create(genre);
//        assertEquals(create.getGenreId(), create.getGenreId());
//        System.out.println("Create: " + create);
//    }
//
//    @Test
//    void b_read() {
//        MovieGenre read = repo.read(genre.getGenreId());
//        assertNotNull(read);
//        System.out.println("Read: " +read);
//    }
//
//    @Test
//    void c_update() {
//        MovieGenre update = new MovieGenre.Builder().copy(genre).setGenreId("2222").build();
//        //assertNotNull(repo.update(update));
//        System.out.println("Update: " +update);
//    }
//
//    @Test
//    void d_delete() {
//        repo.delete(genre.getGenreId());
//        System.out.println(genre.getGenreId() + " was deleted." );
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println("Get All: " + repo.getAll());
//    }
//
//}