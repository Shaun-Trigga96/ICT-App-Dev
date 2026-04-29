//package za.ac.cput.repository;
//
///*
//    MovieRepositoryTest.java
//    @author:219169640 - Casey Michael Keven Crafford
//    Assignment 3 – Domain Driven Design: Repository
//    26 July 2021
//*/
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Movie;
//import za.ac.cput.factory.MovieFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class MovieRepositoryTest {
//    private static MovieRepository repository=MovieRepository.getRepository();
//    private static Movie movie= MovieFactory.build("Title","26/07/2021","76","567");
//
//    @Test
//    void a_create(){
//        Movie created=repository.create(movie);
//        System.out.println(movie);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Movie read=repository.read(movie.getMovieId());
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Movie updated=new Movie.MovieBuilder().copy(movie).setTitle("New Title").build();
//        System.out.println(updated);
//        assertNotNull(repository.update(updated));
//    }
//
//    @Test
//    void d_getAll(){
//        System.out.println("Show All:");
//        System.out.println(repository.getAll());
//    }
//
//    @Test
//    void e_delete(){
//        boolean success=repository.delete(movie.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}