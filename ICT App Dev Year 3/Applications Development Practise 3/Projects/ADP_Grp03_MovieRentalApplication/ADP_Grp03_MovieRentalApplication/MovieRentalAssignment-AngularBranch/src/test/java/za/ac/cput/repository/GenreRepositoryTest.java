//package za.ac.cput.repository;
///**
// * Author: Emilio Castano
// * Student Number: 219035709
// *
// */
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Genre;
//import za.ac.cput.factory.GenreFactory;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//
//public class GenreRepositoryTest {
//    private static GenreRepository repository = GenreRepository.getRepository();
//    private static Genre genre = GenreFactory.build("HOR", "Horror", "These horrors will give you sleepless nights and and scream like never before");
//
//
//    @Test
//    void e_getAll() {
//        System.out.println("Show All:");
//        System.out.println(repository.getAll());
//    }
//
//    @Test
//    void a_create() {
//        Genre created = repository.create(genre);
//        assertEquals(genre.getGenreId(),created.getGenreId());
//        //assertEquals(created.genreId(), genre.toString()); //genreId must change
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    void b_read() {
//        Genre read = repository.read(genre.getGenreId());
//        System.out.println("Read: " + read);
//
//    }
//
//    @Test
//    void c_update() {
//        Genre updated = new Genre.genreBuilder().copy(genre).setGenreId("Hor").build();
//        System.out.println("Updated: " + updated);
//
//    }
//
//    @Test
//    void d_delete() {
//        repository.delete(genre.getGenreId());
//        System.out.println("Deleted: " + genre.getGenreId() + "");
//    }
//}