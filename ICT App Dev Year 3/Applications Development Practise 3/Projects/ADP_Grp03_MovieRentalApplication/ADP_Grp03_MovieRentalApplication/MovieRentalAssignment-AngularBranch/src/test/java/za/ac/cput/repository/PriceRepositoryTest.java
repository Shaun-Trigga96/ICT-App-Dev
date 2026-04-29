//package za.ac.cput.repository;
//
///*
//    PriceRepositoryTest.java
//    @author:219169640 - Casey Michael Keven Crafford
//    Assignment 3 – Domain Driven Design: Repository
//    26 July 2021
//*/
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Movie;
//import za.ac.cput.entity.Price;
//import za.ac.cput.factory.MovieFactory;
//import za.ac.cput.factory.PriceFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class PriceRepositoryTest {
//    private static PriceRepository repository=PriceRepository.getRepository();
//    private static Price price = PriceFactory.build(50.00f);
//
//    @Test
//    void a_create(){
//        Price created=repository.create(price);
//        System.out.println(price);
//        assertNotNull(created);
//    }
//
//    @Test
//    void b_read(){
//        Price read=repository.read(price.getMovieId());
//        System.out.println("Read: "+read);
//    }
//
//    @Test
//    void c_update(){
//        Price updated=new Price.PriceBuilder().copy(price).setAmount(55.00f).build();
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
//        boolean success=repository.delete(price.getMovieId());
//        assertTrue(success);
//        System.out.println("Delete status: "+success);
//    }
//}