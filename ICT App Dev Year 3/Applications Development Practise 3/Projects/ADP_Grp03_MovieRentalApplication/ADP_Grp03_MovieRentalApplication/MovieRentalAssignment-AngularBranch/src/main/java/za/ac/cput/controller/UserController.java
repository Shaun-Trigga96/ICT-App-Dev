package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create (@RequestBody User user) {
        User newUser = UserFactory.build(user.getUserId(),user.getAddress(),user.getIdNumber(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getCellNumber());
        return userService.create(newUser);

    }

    @GetMapping("/read{userId}")
    public User read(@PathVariable User user) {

        return userService.read(user.getUserId());
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);

    }
    @GetMapping("/getall")
    public Set<User> getAll() {

        return userService.getAll();
    }

    @PostMapping("/delete{userId}")
    public boolean delete (@PathVariable String userId) {
       return userService.delete(userId);
    }

    @GetMapping("/getSingleUser")
    public Set<User> getSingleUser(){
        return userService.getAllUsersStartWithA();
    }
}
