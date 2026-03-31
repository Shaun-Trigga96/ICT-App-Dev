package za.ac.cput.factory;

import za.ac.cput.entity.User;
import java.util.UUID;
/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

public class UserFactory {

    public static User build(String userId , String address , String idNumber,String firstName , String lastName, String email, String cellNumber)
    {
        if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || idNumber.isEmpty() ||email.isEmpty() || cellNumber.isEmpty() )
            return null;

        String userID = UUID.randomUUID().toString();

        return new User.userBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserId(userID)
                .setAddress(address)
                .setIdNumber(idNumber)
                .setEmail(email)
                .setCellNumber(cellNumber)
                .build();
    }
}
