package za.ac.cput.repository;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import za.ac.cput.entity.userRole;

import java.util.Set;
@Deprecated
public interface IUserRoleRepository extends IRepository<userRole , String>{

    public Set<userRole> getAll();
}
