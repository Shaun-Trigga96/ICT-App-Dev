package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.User;
import za.ac.cput.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {


    private static UserService service =null;

    @Autowired
    private UserRepository repo;

    @Override
    public User create(User user){return this.repo.save(user);}

    @Override
    public User read(String userId){return this.repo.findById(userId).orElse(null);}

    @Override
    public User update(User user){
        if(this.repo.existsById(user.getUserId()))
            return this.repo.save(user);
        return null;
    }

    @Override
    public boolean delete(String userId){
        this.repo.deleteById(userId);
        if(this.repo.existsById(userId))
            return false;
        else
            return true;
    }

    @Override
    public Set<User> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<User> getAllUsersStartWithA(){
        Set<User> UserWithA = new HashSet<>();
        Set<User> users = getAll();

        for (User user : users){
            if (user.getFirstName().trim().toLowerCase().startsWith("a")){
                UserWithA.add(user);
            }
        }
        return UserWithA;
    }

    public User getUserGivenLastname(String lastName){
        User u =null;
        Set<User> users = getAll();

        for(User user : users){
            if (user.getLastName().equals(lastName)){
                u = user;
                break;
            }
        }
        return u;
    }

}
