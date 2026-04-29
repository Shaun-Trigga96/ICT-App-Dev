package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import za.ac.cput.entity.Role;

import java.util.Set;

public interface IRoleService extends IService<Role,String>{

    public Set<Role> getAll();
}
