package za.ac.cput.service;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserRental;
import za.ac.cput.repository.UserRentalRepo;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRentalService implements IUserRentalService {

    public static UserRentalService service = null;

    @Autowired
    private UserRentalRepo repository;

    @Override
    public UserRental create(UserRental userRental) {
        return this.repository.save(userRental);
    }

    @Override
    public UserRental read(String rentalId) {
        return this.repository.findById(rentalId).orElse(null);
    }

    @Override
    public UserRental update(UserRental userRental) {
        if(this.repository.existsById(userRental.getRentalId())){
            return this.repository.save(userRental);
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
    public Set<UserRental> getAll() {
       return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
