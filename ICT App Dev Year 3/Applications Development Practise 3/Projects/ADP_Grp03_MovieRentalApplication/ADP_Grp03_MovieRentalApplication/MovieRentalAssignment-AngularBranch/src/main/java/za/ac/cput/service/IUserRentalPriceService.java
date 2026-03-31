package za.ac.cput.service;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRentalPrice;
import java.util.Set;

    public interface IUserRentalPriceService extends IService<UserRentalPrice, String> {
        public Set<UserRentalPrice> getAll();
    }
