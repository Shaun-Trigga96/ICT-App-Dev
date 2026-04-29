package za.ac.cput.service;

/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 22 August 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.ContactType;
import za.ac.cput.repository.ContactTypeRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactTypeService implements IContactTypeService {

    private static ContactTypeService service =null;

    @Autowired
    private ContactTypeRepository repo;

    @Override
    public ContactType create(ContactType contactType){return this.repo.save(contactType);}

    @Override
    public ContactType read(String contactTypeId){return this.repo.findById(contactTypeId).orElse(null);}

    @Override
    public ContactType update(ContactType contactType){
        if(this.repo.existsById(contactType.getContactTypeId()))
            return this.repo.save(contactType);
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
    public Set<ContactType> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<ContactType> getAllAddressStartWithA(){
        Set<ContactType> AddressWithA = new HashSet<>();
        Set<ContactType> contactTypes = getAll();

        for (ContactType contactType : contactTypes){
            if (contactType.toString().trim().toLowerCase().startsWith("a")){
                AddressWithA.add(contactType);
            }
        }
        return AddressWithA;
    }


}
