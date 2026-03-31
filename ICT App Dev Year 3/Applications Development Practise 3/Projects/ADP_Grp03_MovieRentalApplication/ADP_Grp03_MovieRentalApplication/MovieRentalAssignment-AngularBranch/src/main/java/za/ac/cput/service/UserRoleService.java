package za.ac.cput.service;


/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.userRole;
import za.ac.cput.repository.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleService implements IUserRoleService {

    private static UserRoleService service =null;

    @Autowired
    private UserRoleRepository repo;

    @Override
    public userRole create(userRole userrole){return this.repo.save(userrole);}

    @Override
    public userRole read(String userId){return this.repo.findById(userId).orElse(null);}

    @Override
    public userRole update(userRole userrole){
        if(this.repo.existsById(userrole.getUserId()))
            return this.repo.save(userrole);
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
    public Set<userRole> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<userRole> getAlluserRoleStartWithA(){
        Set<userRole> userRoleWithA = new HashSet<>();
        Set<userRole> userroles = getAll();

        for (userRole userrole : userroles){
            if (userrole.getUserId().trim().toLowerCase().startsWith("1")){
                userRoleWithA.add(userrole);
            }
        }
        return userRoleWithA;
    }

    public userRole getuserRoleGivenid(String userId){
        userRole ur =null;
        Set<userRole> userroles = getAll();

        for(userRole userrole : userroles){
            if (userrole.getUserId().equals(userId)){
                ur = userrole;
                break;
            }
        }
        return ur;
    }
}
