package za.ac.cput.controller;

/*
    StockController.java
    @author:219169640 - Casey Michael Keven Crafford
    Assignment 3 – Domain Driven Design: Entity and Factory
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Stock;
import za.ac.cput.factory.StockFactory;
import za.ac.cput.service.StockService;

import java.util.Set;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public Stock create(@RequestBody Stock stock) {
        Stock newStock = StockFactory.build(stock.getQuantity());
        return stockService.create(newStock);
    }

    @GetMapping("/read{movieId}")
    public Stock read(@PathVariable String movieId){
        return stockService.read(movieId);
    }

    @PostMapping("/update")
    public Stock update(@RequestBody Stock stock){
        return stockService.update(stock);
    }

    @DeleteMapping("/delete{movieId}")
    public boolean delete(@PathVariable String movieId){
        return stockService.delete(movieId);
    }
    @GetMapping("/getall")
    public Set <Stock> getAll(){
        return stockService.getAll();
    }
}
