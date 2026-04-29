package za.ac.cput.service;
/* UserContact.java

 Author: Malcolm Camelo (217137334)
 Date: 22 August 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import za.ac.cput.entity.UserContact;
import za.ac.cput.repository.UserContactRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserContactService implements IUserContactService{


    private static UserContactService service =null;

    @Autowired
    private UserContactRepository repo;

    @Override
    public UserContact create(UserContact userContact){return this.repo.save(userContact);}

    @Override
    public UserContact read(String userId){return this.repo.findById(userId).orElse(null);}

    @Override
    public UserContact update(UserContact userContact){
        if(this.repo.existsById(userContact.getContactId()))
            return this.repo.save(userContact);
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
    public Set<UserContact> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<UserContact> getAllAddressStartWithA(){
        Set<UserContact> AddressWithA = new HashSet<>();
        Set<UserContact> userContacts = getAll();

        for (UserContact userContact : userContacts){
            if (userContact.toString().trim().toLowerCase().startsWith("a")){
                AddressWithA.add(userContact);
            }
        }
        return AddressWithA;
    }




}
