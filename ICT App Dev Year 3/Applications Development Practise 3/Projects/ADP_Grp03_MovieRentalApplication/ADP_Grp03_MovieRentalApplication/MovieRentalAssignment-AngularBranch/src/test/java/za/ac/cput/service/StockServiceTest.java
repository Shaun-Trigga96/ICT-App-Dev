/*
package za.ac.cput.service;

*/
/*
    StockServiceTest.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Service
    26 July 2021
*//*


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Stock;
import za.ac.cput.factory.StockFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StockServiceTest {
    private static IStockService service = StockService.getService();
    private static Stock stock = StockFactory.build(3);

    @Test
    void a_create(){
        Stock created=service.create(stock);
        System.out.println(stock);
        assertNotNull(created);
    }

    @Test
    void b_read(){
        Stock read=service.read(stock.getMovieId());

        System.out.println("Read: "+read);
    }

    @Test
    void c_update(){
        Stock updated=new Stock.StockBuilder().copy(stock).setQuantity(4).build();
        System.out.println(updated);
        assertNotNull(service.update(updated));
    }

    @Test
    void d_getAll(){
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }

    @Test
    void e_delete(){
        boolean success=service.delete(stock.getMovieId());
        assertTrue(success);
        System.out.println("Delete status: "+success);
    }
}*/
