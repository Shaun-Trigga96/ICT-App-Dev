package za.ac.cput.factory.user;

import za.ac.cput.entity.user.User;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class UserFactory {

    public static User createUser(String username, String userEmail, String password, String confirmEmail, String confirmPassword) {
        if (StringHelper.isNullorEmpty(username)) return new User.Builder().build();
        if (StringHelper.isNullorEmpty(password)) return new User.Builder().build();
        if (StringHelper.isNullorEmpty(confirmEmail)) return new User.Builder().build();
        if (StringHelper.isNullorEmpty(confirmPassword)) return new User.Builder().build();
        String userId = GenericHelper.generateRandom();
        User registration = new User.Builder()
                .setUserId(userId)
                .setUsername(username)
                .setUserEmail(userEmail)
                .setPassword(password)
                .setConfirmEmail(confirmEmail)
                .setConfirmPassword(confirmPassword)
                .build();
        return registration;
    }
}
