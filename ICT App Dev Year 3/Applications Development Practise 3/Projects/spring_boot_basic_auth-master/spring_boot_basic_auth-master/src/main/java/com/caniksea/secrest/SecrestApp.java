package com.caniksea.secrest;

import com.caniksea.secrest.domain.Country;
import com.caniksea.secrest.factory.CountryFactory;
import com.caniksea.secrest.service.country.impl.CountryServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caniksea on 8/14/17.
 */
@Controller
@RequestMapping(path="/secrest")
public class SecrestApp {

    @Autowired
    private CountryServiceImpl countryService;

    @GetMapping(path="/add/{countryName}")
    public @ResponseBody String addCountry(@PathVariable String countryName){
        Country country = CountryFactory.buildCountry(countryName);
        countryService.save(country);
        return new Gson().toJson(country);
    }
}
