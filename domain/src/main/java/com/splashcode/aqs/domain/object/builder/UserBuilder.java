package com.splashcode.aqs.domain.object.builder;

import com.splashcode.aqs.domain.object.Address;
import com.splashcode.aqs.domain.object.Company;
import com.splashcode.aqs.domain.object.User;

public class UserBuilder {
    private String userName;
    private String phone;
    private String email;
    private Address address;
    private Company company;

    public UserBuilder setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setPhone(final String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setAddress(final Address address) {
        this.address = address;
        return this;
    }

    public UserBuilder setCompany(final Company company) {
        this.company = company;
        return this;
    }

    public User createUser() {
        return new User(userName, phone, email, address, company);
    }
}