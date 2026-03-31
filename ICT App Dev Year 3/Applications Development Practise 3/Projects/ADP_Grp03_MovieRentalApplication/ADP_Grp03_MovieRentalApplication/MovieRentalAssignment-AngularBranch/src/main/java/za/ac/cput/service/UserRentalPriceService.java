package za.ac.cput.service;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserRentalPrice;
import za.ac.cput.repository.UserRentalPriceRepo;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRentalPriceService implements IUserRentalPriceService {

    private static za.ac.cput.service.UserRentalPriceService service = null;

    @Autowired
    private UserRentalPriceRepo repository;

    @Override
    public UserRentalPrice create(UserRentalPrice userRentalPrice) {
        return this.repository.save(userRentalPrice);
    }

    @Override
    public UserRentalPrice read(String rentalId) {
        return this.repository.findById(rentalId).orElse(null);
    }

    @Override
    public UserRentalPrice update(UserRentalPrice userRentalPrice) {
        if(this.repository.existsById(userRentalPrice.getRentalId())){
            return this.repository.save(userRentalPrice);
        }
        return null;
    }

    @Override
    public boolean delete(String rentalId) {
        this.repository.deleteById(rentalId);
        if(this.repository.existsById(rentalId)){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Set<UserRentalPrice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}