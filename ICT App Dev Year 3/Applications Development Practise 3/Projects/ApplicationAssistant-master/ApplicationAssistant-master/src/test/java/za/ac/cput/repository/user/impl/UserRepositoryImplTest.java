//package za.ac.cput.repository.user.impl;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.user.User;
//import za.ac.cput.factory.user.UserFactory;
//import za.ac.cput.repository.user.UserRepository;
//import za.ac.cput.repository.user.impl.UserRepositoryImpl;
//
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UserRepositoryImplTest {
//
//    @Autowired
//    private UserRepository repository ;
//    private static User user = UserFactory.createUser("Sonia_Sontshatsha", "ssontshatsha@yahoo.com", "123", "ssontshatsha@yahoo.com", "123");
//
//    @Test
//    public void d_getAll()
//    {
//        System.out.println("Get All: " + repository.findAll());
//    }
//
//    @Test
//    public void a_create()
//    {
//        User created = repository.create(user);
//        Assert.assertEquals(user.getUsername(), created.getUsername());
//        Assert.assertEquals(user.getUserEmail(), created.getUserEmail());
//        Assert.assertEquals(user.getPassword(),created.getPassword());
//        Assert.assertEquals(user.getConfirmEmail(),created.getConfirmEmail());
//        Assert.assertEquals(user.getConfirmPassword(),created.getConfirmPassword());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        User read = repository.read(user.getUserId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        User updated = new User.Builder().copy(user).setPassword("456").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.delete(user.getUserId());
//        Assert.assertTrue(deleted);
//    }
//}
