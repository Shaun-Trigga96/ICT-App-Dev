package com.caniksea.secrest.repository;

import com.caniksea.secrest.domain.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by caniksea on 8/14/17.
 */
public interface CountryRepository extends CrudRepository<Country, String> {
}
