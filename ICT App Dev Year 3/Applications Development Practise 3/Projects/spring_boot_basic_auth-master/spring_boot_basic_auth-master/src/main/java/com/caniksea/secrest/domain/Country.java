package com.caniksea.secrest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by caniksea on 8/14/17.
 */
@Entity
public class Country implements Serializable, Comparable<Country> {

    @Id
    private String id;
    private String country_name;

    private Country() {
    }

    public Country(Builder builder) {
        this.id = builder.id;
        this.country_name = builder.country_name;
    }

    public static class Builder {
        private String id, country_name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder countryName(String countryName) {
            this.country_name = countryName;
            return this;
        }

        public Builder copy(Country country) {
            this.id = country.id;
            this.country_name = country.country_name;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }


    public int compareTo(Country country) {
        return id.compareTo(country.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return id.equals(country.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
