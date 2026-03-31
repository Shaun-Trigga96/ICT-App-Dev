package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

import za.ac.cput.entity.userRole;

import java.util.Set;

public interface IUserRoleService extends IService<userRole,String> {

    public Set<userRole> getAll();

}
