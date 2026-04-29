package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Price;
import za.ac.cput.repository.PriceRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PriceService implements IPriceService{
    private static PriceService service = null;

    @Autowired
    private PriceRepository repository;

    @Override
    public Price create (Price price){
        return this.repository.save(price);
    }

    @Override
    public Price read (String movieId){
        return this.repository.findById(movieId).orElse(null);
    }

    @Override
    public Price update (Price price){
        if(this.repository.existsById(price.getMovieId()))
            return this.repository.save(price);
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
    public Set<Price> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    public Price getPriceGivenTitle(double amount){
        Price p = null;
        Set<Price> prices = getAll();
        for (Price price : prices){
            if(price.getAmount()==amount){
                p = price;
                break;
            }
        }
        return p;
    }

}//end of class