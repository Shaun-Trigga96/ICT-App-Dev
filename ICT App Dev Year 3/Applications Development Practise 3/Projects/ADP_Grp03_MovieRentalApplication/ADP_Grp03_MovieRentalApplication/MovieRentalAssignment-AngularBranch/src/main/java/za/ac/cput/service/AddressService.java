package za.ac.cput.service;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AddressService implements IAddressService{

    private static AddressService service =null;

    @Autowired
    private AddressRepository repo;

    @Override
    public Address create(Address address){return this.repo.save(address);}

    @Override
    public Address read(String userId){return this.repo.findById(userId).orElse(null);}

    @Override
    public Address update(Address address){
        if(this.repo.existsById(address.getUserId()))
            return this.repo.save(address);
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
    public Set<Address> getAll() {
        return this.repo.findAll().stream().collect(Collectors.toSet());
    }

    public Set<Address> getAllAddressStartWithA(){
        Set<Address> AddressWithA = new HashSet<>();
        Set<Address> addresses = getAll();

        for (Address address : addresses){
            if (address.getCountry().trim().toLowerCase().startsWith("a")){
                AddressWithA.add(address);
            }
        }
        return AddressWithA;
    }

    public Address getAddressGivenCountry(String country){
        Address a =null;
        Set<Address> addresses = getAll();

        for(Address address : addresses){
            if (address.getCountry().equals(country)){
                a = address;
                break;
            }
        }
        return a;
    }

}
