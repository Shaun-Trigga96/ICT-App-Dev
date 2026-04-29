//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Rating;
//import za.ac.cput.factory.RatingFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class RatingServiceTest {
//    private static IRatingService service = RatingService.getService();
//    private static Rating rating = RatingFactory.build(9);
//
//    @Test
//    void a_create(){
//        Rating created=service.create(rating);
//        System.out.println(rating);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Rating read=service.read(rating.getMovieId());
//
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Rating updated=new Rating.RatingBuilder().copy(rating).setRating(6).build();
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
//        boolean success=service.delete(rating.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}