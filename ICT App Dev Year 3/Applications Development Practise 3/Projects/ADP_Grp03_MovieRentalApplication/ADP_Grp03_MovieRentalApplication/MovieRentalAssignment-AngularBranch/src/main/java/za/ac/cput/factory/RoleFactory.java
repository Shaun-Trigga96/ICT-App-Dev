package za.ac.cput.factory;

import za.ac.cput.entity.Role;

import java.util.UUID;
/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

public class RoleFactory {

    public static Role build(String roleId , String name , String description)
    {
        if (name.isEmpty()||description.isEmpty()|| roleId.isEmpty())
        {
            return null;
        }

        String roleID = UUID.randomUUID().toString();

        return new Role.roleBuilder()
                .setDescription(description).setRoleId(roleID).setName(name).build();
    }
}
