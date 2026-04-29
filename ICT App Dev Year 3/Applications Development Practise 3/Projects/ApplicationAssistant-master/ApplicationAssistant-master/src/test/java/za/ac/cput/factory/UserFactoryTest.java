package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.user.User;
import za.ac.cput.factory.user.UserFactory;

public class UserFactoryTest {

    @Test
    public void createNewUser() {
        User registration = UserFactory.createUser("Steven", "steven@gmail.com", "stev1357", "steven@gmail.com", "stev1357");

        Assert.assertEquals("Steven", registration.getUsername());
        Assert.assertEquals("steven@gmail.com", registration.getUserEmail());
        Assert.assertEquals("stev1357", registration.getPassword());
        Assert.assertEquals("steven@gmail.com", registration.getConfirmEmail());
        Assert.assertEquals("stev1357", registration.getConfirmPassword());
    }
}