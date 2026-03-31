//package za.ac.cput.service;
//
///**
// * Author: Lance Kruger
// * Student Number: 218159501
// * Program:Movies Rented Service Test
// *lk
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.MovieRentedOut;
//import za.ac.cput.factory.MoviesRentedOutFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//@Deprecated
//@TestMethodOrder(MethodOrderer.MethodName.class)
//
//public class MovieRentedOutServiceTest {
//    private static IMovieRentedOutService service = MovieRentedOutService.getService();
//    private static MovieRentedOut movieRentedOut = MoviesRentedOutFactory.build("A5Jk52", 10);
//
//    @Test
//    void Create()
//    {
//        MovieRentedOut built =service.create(movieRentedOut);
//
//        assertEquals(built.getMovieID() , movieRentedOut.getMovieID());
//        System.out.println("Create :"+ built);
//
//    }
//    @Test
//    void Read()
//    {
//        MovieRentedOut read = service.read(movieRentedOut.getMovieID());
//        System.out.println("Read : " + read);
//
//    }
//    @Test
//    void Update()
//    {
//        MovieRentedOut updated = new MovieRentedOut.MovieRentedOutBuilder().copy(movieRentedOut).setMovieID("A5Jk52").setQuantity(5).build();
//        System.out.println("updated : "+ updated);
//
//
//    }
//    @Test
//    void Delete()
//    {
//        boolean success =service.delete(movieRentedOut.getMovieID());
//        assertTrue(success);
//        System.out.println("Deleted : "+ success);
//
//    }
//
//    @Test
//    void getAll()
//    {
//        System.out.println("Show All : ");
//        System.out.println(service.getAll());
//
//    }
//}
