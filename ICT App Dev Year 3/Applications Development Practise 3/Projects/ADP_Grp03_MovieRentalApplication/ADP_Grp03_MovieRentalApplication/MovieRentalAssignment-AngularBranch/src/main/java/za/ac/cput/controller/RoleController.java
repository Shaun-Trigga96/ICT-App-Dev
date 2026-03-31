package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.service.RoleService;


import java.util.Set;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public Role create (@RequestBody Role role) {
        Role newRole = RoleFactory.build(role.getRoleId(),role.getName(),role.getDescription());
        return roleService.create(newRole);

    }

    @GetMapping("/read{roleId}")
    public Role read(@PathVariable Role role) {

        return roleService.read(role.getRoleId());
    }

    @PostMapping("/update")
    public Role update(@RequestBody Role role){
        return roleService.update(role);

    }
    @GetMapping("/getall")
    public Set<Role> getAll() {

        return roleService.getAll();
    }

    @PostMapping("/delete{roleId}")
    public boolean delete (@PathVariable String roleId) {
        return roleService.delete(roleId);
    }

    @GetMapping("/getSingleRole")
    public Set<Role> getSingleRole(){
        return roleService.getAllRoleStartWithA();
    }
}
