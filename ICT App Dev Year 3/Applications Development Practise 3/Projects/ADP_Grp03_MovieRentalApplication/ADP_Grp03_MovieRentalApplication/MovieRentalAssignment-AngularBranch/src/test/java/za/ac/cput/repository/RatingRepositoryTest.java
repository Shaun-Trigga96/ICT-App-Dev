//package za.ac.cput.repository;
//
///*
//    RatingRepositoryTest.java
//    @author:219169640 - Casey Michael Keven Crafford
//    Assignment 3 – Domain Driven Design: Repository
//    26 July 2021
//*/
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Movie;
//import za.ac.cput.entity.Rating;
//import za.ac.cput.factory.MovieFactory;
//import za.ac.cput.factory.RatingFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class RatingRepositoryTest {
//    private static RatingRepository repository=RatingRepository.getRepository();
//    private static Rating rating = RatingFactory.build(9);
//
//    @Test
//    void a_create(){
//        Rating created=repository.create(rating);
//        System.out.println(rating);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Rating read=repository.read(rating.getMovieId());
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Rating updated=new Rating.RatingBuilder().copy(rating).setRating(6).build();
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
//        boolean success=repository.delete(rating.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}