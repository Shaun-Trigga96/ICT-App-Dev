package za.ac.cput.factory;

import za.ac.cput.entity.Address;

import java.util.UUID;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

public class AddressFactory {

    public static Address build(String street , String city , String country , String province , int postalCode,String userId)
    {
        if (street.isEmpty()|| city.isEmpty()||country.isEmpty()||province.isEmpty()|| postalCode <=0 ||userId.isEmpty())
            return null;

        String userID = UUID.randomUUID().toString();

        return new Address.addressBuilder()
                .setCity(city).setCountry(country).setPostalCode(postalCode).setProvince(province).setuserId(userID)
                .setStreet(street).build();

    }
}
