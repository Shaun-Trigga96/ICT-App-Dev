package za.ac.cput.service.user.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.user.User;
import za.ac.cput.factory.user.UserFactory;
import za.ac.cput.service.user.UserService;
//import za.ac.cput.util.SendHTMLEmail;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    @Autowired
    private  UserService service ;
    private static User user = UserFactory.createUser("Abdullah", "abdullahryklief@gmail.com", "Password123", "abdullahryklief@gmail.com", "Password123");

    @Test
    public void d_getAll() {
        Set<User> users = service.getAll();
        Assert.assertEquals(1, users.size());
        System.out.println("Get All: " + users);
    }

//    @Test
//    public void e_emailApplicationForm() {
//        User created = service.create(user);
//        Assert.assertEquals(user.getUserEmail(), created.getUserEmail());
//        Assert.assertEquals(user.getConfirmEmail(), created.getConfirmEmail());
//        SendHTMLEmail.sendEmail(user.getUserEmail());
//        System.out.println("Email successfully sent to: " + user.getUserEmail());
//    }

    @Test
    public void a_create() {
        User created = service.create(user);
        Assert.assertEquals(user.getUserId(),created.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        User read = service.read(user.getUserId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setPassword("NewPassword321").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(user.getUserId());
        Assert.assertTrue(deleted);
    }
}