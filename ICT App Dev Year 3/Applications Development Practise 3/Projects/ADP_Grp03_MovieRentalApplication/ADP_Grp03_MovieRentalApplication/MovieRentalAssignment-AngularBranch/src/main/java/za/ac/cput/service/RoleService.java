package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {

    private static RoleService service =null;

    @Autowired
    private RoleRepository repo;

    @Override
    public Role create(Role role){return this.repo.save(role);}

    @Override
    public Role read(String roleId){return this.repo.findById(roleId).orElse(null);}

    @Override
    public Role update(Role role){
        if(this.repo.existsById(role.getRoleId()))
            return this.repo.save(role);
        return null;
    }

    @Override
    public boolean delete(String roleId){
        this.repo.deleteById(roleId);
        if(this.repo.existsById(roleId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Role> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<Role> getAllRoleStartWithA(){
        Set<Role> RoleWithA = new HashSet<>();
        Set<Role> roles = getAll();

        for (Role role : roles){
            if (role.getDescription().trim().toLowerCase().startsWith("a")){
                RoleWithA.add(role);
            }
        }
        return RoleWithA;
    }

    public Role getRoleGivenDescription(String description){
        Role r =null;
        Set<Role> roles = getAll();

        for(Role role : roles){
            if (role.getDescription().equals(description)){
                r =role;
                break;
            }
        }
        return r;
    }
}
