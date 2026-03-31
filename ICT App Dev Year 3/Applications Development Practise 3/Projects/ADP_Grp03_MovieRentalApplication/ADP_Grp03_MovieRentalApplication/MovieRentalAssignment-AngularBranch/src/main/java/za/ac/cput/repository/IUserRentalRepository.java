package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRental;
import java.util.Set;

public interface IUserRentalRepository extends IRepository<UserRental, String> {
    public Set<UserRental> getAll();
}
