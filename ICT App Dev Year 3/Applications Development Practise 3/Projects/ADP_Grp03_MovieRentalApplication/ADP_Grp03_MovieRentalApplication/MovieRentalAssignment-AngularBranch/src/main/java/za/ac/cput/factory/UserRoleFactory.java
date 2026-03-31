package za.ac.cput.factory;

import za.ac.cput.entity.userRole;

import java.util.UUID;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

public class UserRoleFactory {

    public static userRole build(String userId , int roleId)
    {
        if( roleId <= 0 || userId.isEmpty())
            return null;

        String userID = UUID.randomUUID().toString();

        return new userRole.userRoleBuilder()
                .setRoleId(roleId).setUserId(userID).build();
    }
}
