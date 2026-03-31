//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Price;
//import za.ac.cput.factory.PriceFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class PriceServiceTest {
//    private static IPriceService service = PriceService.getService();
//    private static Price price = PriceFactory.build(50.00f);
//
//    @Test
//    void a_create(){
//        Price created=service.create(price);
//        System.out.println(price);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Price read=service.read(price.getMovieId());
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Price updated=new Price.PriceBuilder().copy(price).setAmount(55.00f).build();
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
//        boolean success=service.delete(price.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}