package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import za.ac.cput.entity.Address;

import java.util.Set;

public interface IAddressService extends IService<Address, String>{

   Set<Address> getAll();
}
