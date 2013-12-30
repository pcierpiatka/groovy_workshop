package org.spockworkshop.groovy;

import org.spockworkshop.domain.Address;

public class JavaPerson {

    private String firstName;
    private String lastName;
    private Address address;

    public JavaPerson(String firstName) {
        this.firstName = firstName;
    }

    public JavaPerson(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    public JavaPerson(String firstName, Address address) {
        this(firstName, null, address);
    }
    public JavaPerson(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
