package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.User;
import za.ac.cput.factory.user.UserFactory;
import za.ac.cput.service.user.impl.UserServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public User create(@RequestBody User user)
    {
        user = UserFactory.createUser(user.getUsername(), user.getUserEmail(), user.getPassword(), user.getConfirmPassword(), user.getConfirmEmail());
        return userService.create(user);
    }

    @GetMapping("/all")
    public Set<User> getAll()
    {
        return userService.getAll();
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable String id)
    {
        return userService.read(id);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id)
    {
        return userService.delete(id);
    }
}
