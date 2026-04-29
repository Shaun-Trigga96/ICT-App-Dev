package za.ac.cput.repository;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRentalPrice;
import java.util.Set;
@Deprecated
public interface IUserRentalPriceRepository extends IRepository<UserRentalPrice, String> {
    public Set<UserRentalPrice> getAll();
}
