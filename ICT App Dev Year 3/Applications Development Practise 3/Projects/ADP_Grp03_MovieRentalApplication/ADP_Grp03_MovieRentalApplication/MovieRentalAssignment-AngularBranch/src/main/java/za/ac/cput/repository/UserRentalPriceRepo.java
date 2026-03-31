package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserRentalPrice;

@Repository
public interface UserRentalPriceRepo extends JpaRepository<UserRentalPrice, String> {
}
