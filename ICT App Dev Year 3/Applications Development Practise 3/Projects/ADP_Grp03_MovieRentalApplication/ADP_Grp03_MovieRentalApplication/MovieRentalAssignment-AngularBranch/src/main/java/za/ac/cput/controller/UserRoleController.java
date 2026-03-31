package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.userRole;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.RoleService;
import za.ac.cput.service.UserRoleService;

import java.util.Set;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService UserroleService;

    @PostMapping("/create")
    public userRole create (@RequestBody userRole userrole) {
        userRole newUserRole = UserRoleFactory.build(userrole.getUserId(),userrole.getRoleId());
        return UserroleService.create(newUserRole);

    }

    @GetMapping("/read{userId}")
    public userRole read(@PathVariable userRole userrole) {

        return UserroleService.read(userrole.getUserId());
    }

    @PostMapping("/update")
    public userRole update(@RequestBody userRole userrole){
        return UserroleService.update(userrole);

    }
    @GetMapping("/getall")
    public Set<userRole> getAll() {

        return UserroleService.getAll();
    }

    @PostMapping("/delete{roleId}")
    public boolean delete (@PathVariable String userId) {
        return UserroleService.delete(userId);
    }

    @GetMapping("/getSingleRole")
    public Set<userRole> getSingleUserRole(){
        return UserroleService.getAlluserRoleStartWithA();
    }
}
