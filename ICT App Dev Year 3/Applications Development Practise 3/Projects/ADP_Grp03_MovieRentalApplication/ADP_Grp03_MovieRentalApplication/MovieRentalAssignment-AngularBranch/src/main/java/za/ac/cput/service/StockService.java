package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Stock;
import za.ac.cput.repository.StockRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StockService implements IStockService {
    private static za.ac.cput.service.MovieService service = null;

    @Autowired
    private StockRepository repository;

    @Override
    public Stock create (Stock stock){
        return this.repository.save(stock);
    }

    @Override
    public Stock read (String movieId){
        return this.repository.findById(movieId).orElse(null);
    }

    @Override
    public Stock update (Stock stock){
        if(this.repository.existsById(stock.getMovieId()))
            return this.repository.save(stock);
        return null;
    }

    @Override
    public boolean delete(String movieId){
        this.repository.deleteById(movieId);
        if(this.repository.existsById(movieId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Stock> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Stock getMovieGivenQuantity(int quantity){
        Stock s = null;
        Set<Stock> stocks = getAll();
        for (Stock stock : stocks){
            if(stock.getQuantity()==quantity){
                s = stock;
                break;
            }
        }
        return s;
    }

}//end of class