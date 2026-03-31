package com.caniksea.secrest.service.country.impl;

import com.caniksea.secrest.domain.Country;
import com.caniksea.secrest.repository.CountryRepository;
import com.caniksea.secrest.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by caniksea on 8/14/17.
 */
@Component
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country entity) {
        return countryRepository.save(entity);
    }

    @Override
    public Country findById(String s) {
        return countryRepository.findOne(s);
    }

    @Override
    public Country update(String s) {
        return null;
    }
}
