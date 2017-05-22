package com.splashcode.aqs.domain.object.builder;

import com.splashcode.aqs.domain.object.Address;

public class AddressBuilder {
    private String streetName;
    private String addressExtension;
    private String zipcode;
    private String cityName;
    private String latitude;
    private String longitude;

    public AddressBuilder setStreetName(final String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressBuilder setAddressExtension(final String addressExtension) {
        this.addressExtension = addressExtension;
        return this;
    }

    public AddressBuilder setZipcode(final String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AddressBuilder setCityName(final String cityName) {
        this.cityName = cityName;
        return this;
    }

    public AddressBuilder setLatitude(final String latitude) {
        this.latitude = latitude;
        return this;
    }

    public AddressBuilder setLongitude(final String longitude) {
        this.longitude = longitude;
        return this;
    }

    public Address createAddress() {
        return new Address(streetName, addressExtension, zipcode, cityName, latitude, longitude);
    }
}