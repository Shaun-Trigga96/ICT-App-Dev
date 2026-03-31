package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import za.ac.cput.entity.User;

import java.util.Set;

public interface IUserService extends IService<User, String>{

    public Set<User> getAll();
}
