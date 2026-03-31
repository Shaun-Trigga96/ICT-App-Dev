package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */

@Entity
public class Address{

    @Id
    private String userId;

    private String street , city , country,province;
    private int postalCode;

    public Address()
    {}
    public Address(addressBuilder addressBuilder)
    {
        this.userId = addressBuilder.userId;
        this.street = addressBuilder.street;
        this.city = addressBuilder.city;
        this.country = addressBuilder.country;
        this.province = addressBuilder.province;
        this.postalCode = addressBuilder.postalCode;

    }

    public String getUserId() {
        return userId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public static class addressBuilder
    {
        private String street , city , country,province,userId;
        private int postalCode;

        public addressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public addressBuilder setuserId(String userId) {
            this.userId = userId;
            return this;
        }

        public addressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public addressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public addressBuilder setProvince(String province) {
            this.province = province;
            return this;
        }

        public addressBuilder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build()
        {
            return new Address(this);

        }

        public addressBuilder copy(Address address)
        {
            this.userId = address.userId;
            this.street = address.street;
            this.city = address.city;
            this.country = address.country;
            this.province = address.province;
            this.postalCode = address.postalCode;

            return this;


        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }


}
