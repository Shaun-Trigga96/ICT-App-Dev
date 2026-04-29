//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Movie;
//import za.ac.cput.factory.MovieFactory;
//import za.ac.cput.repository.MovieRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class MovieServiceTest {
//
//    private static IMovieService service = MovieService.getService();
//    private static Movie movie= MovieFactory.build("Title","26/07/2021","76","567","action","studio","actors",20,1);
//
//    @Test
//    void a_create(){
//        Movie created=service.create(movie);
//        System.out.println(movie);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Movie read=service.read(movie.getMovieId());
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Movie updated=new Movie.MovieBuilder().copy(movie).setTitle("New Title").build();
//        System.out.println(updated);
//        assertNotNull(service.update(updated));
//    }
//
//    @Test
//    void d_getAll(){
//        System.out.println("Show All:");
//        System.out.println(service.getAll());
//    }
//
//    @Test
//    void e_delete(){
//        boolean success=service.delete(movie.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}