package za.ac.cput.ADP3LabBookingSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ADP3LabBookingSystem.Entity.Address;
import za.ac.cput.ADP3LabBookingSystem.Factory.AddressFactory;
import za.ac.cput.ADP3LabBookingSystem.Service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")

public class AddressController {

        @Autowired
        private AddressService addressService;

        @PostMapping("/create")
        public Address create(@RequestBody Address address){
            Address newAddress1 = AddressFactory.createAddress(address.getCity(), address.getSuburb(), address.getStreet(), address.getZipCode());
            return  addressService.create(newAddress1);

        }

        @GetMapping("/read/{zipCode}")
        public Address read(@PathVariable String zipCode){
            return addressService.read(zipCode);
        }

        @PostMapping("/Update")
        public Address update(@RequestBody Address address ){
            return addressService.update(address);
        }

        @PostMapping("/delete/{zipcode}")
        public boolean delete(@PathVariable String zipCode){

            return addressService.delete(zipCode);
        }

        @GetMapping("/getall")
        public List<Address> getAll(){
            return addressService.getAll();

        }


    }
