package za.ac.cput.repository;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import za.ac.cput.entity.User;

import java.util.Set;

public interface IUserRepository extends IRepository<User, String>
{

    public Set<User> getAll();

}
