package org.spockworkshop.domain;

public class Address {

    private String country;

    public Address(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
