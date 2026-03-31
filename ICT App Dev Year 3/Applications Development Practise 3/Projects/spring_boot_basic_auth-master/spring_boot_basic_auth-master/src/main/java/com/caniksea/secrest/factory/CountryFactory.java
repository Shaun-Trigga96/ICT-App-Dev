package com.caniksea.secrest.factory;

import com.caniksea.secrest.domain.Country;
import com.caniksea.secrest.utility.KeyGenerator;

/**
 * Created by caniksea on 8/14/17.
 */
public class CountryFactory {
    public static Country buildCountry(String countryName){
        Country country = new Country.Builder()
                .id(KeyGenerator.getEntityId())
                .countryName(countryName)
                .build();
        return country;
    }
}
