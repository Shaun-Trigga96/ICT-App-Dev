package za.ac.cput.service;

/*
 * Author: Grant Constant
 * Student number: 216063124
 */

import za.ac.cput.entity.UserRental;

import java.util.Set;

    public interface IUserRentalService extends IService<UserRental, String>{
        public Set<UserRental> getAll();
    }
