package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.entity.UserContact;
import za.ac.cput.factory.UserContactFactory;
import za.ac.cput.service.UserContactService;

import java.util.Set;


@RestController
@RequestMapping("/UserContact")

public class UserContactController {
    @Autowired
    private UserContactService userContactService;

    @PostMapping("/create")
    public UserContact create(@RequestBody UserContact userContact) {
        UserContact user = UserContactFactory.build(userContact.getContact());

        return userContactService.create(user);
    }

    @GetMapping("/read/{userId}")
    public UserContact read(@PathVariable String userId){
        return userContactService.read(userId);
    }

    @PostMapping("/update")
    public UserContact update(@RequestBody UserContact userContact){
        return userContactService.update(userContact);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return userContactService.delete(userId);
    }
    @GetMapping("/getall")
    public Set<UserContact> getAll(){
        return userContactService.getAll();
    }





}
