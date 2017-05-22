package com.splashcode.aqs.domain.object;

/**
 * Domain object for a User
 */
public class User {
    public static final User EMPTY = null;

    private final String userName;
    private final String phone;
    private final String email;
    private final Address address;
    private final Company company;

    public User(final String userName, final String phone, final String email, final Address address, final Company company) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }
}
