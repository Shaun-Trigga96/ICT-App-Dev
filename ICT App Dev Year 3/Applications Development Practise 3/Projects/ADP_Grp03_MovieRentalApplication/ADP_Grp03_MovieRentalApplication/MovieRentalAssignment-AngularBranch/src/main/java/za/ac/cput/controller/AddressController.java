package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.AddressService;

import java.util.Set;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    private AddressService AddressService;

    @PostMapping("/create")
    public Address create (@RequestBody Address address) {
        Address newAddress = AddressFactory.build(address.getStreet(), address.getCity(),address.getCountry(),address.getProvince()
                                                  ,address.getPostalCode(),address.getUserId());
        return AddressService.create(newAddress);

    }

    @GetMapping("/read{userId}")
    public Address read(@PathVariable Address address) {

        return AddressService.read(address.getUserId());
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address){
        return AddressService.update(address);

    }
    @GetMapping("/getall")
    public Set<Address> getAll() {

        return AddressService.getAll();
    }

    @PostMapping("/delete{userId}")
    public boolean delete (@PathVariable String userId) {
        return AddressService.delete(userId);
    }

    @GetMapping("/getSingleAddress")
    public Set<Address> getSingleAddress(){
        return AddressService.getAllAddressStartWithA();
    }
}
