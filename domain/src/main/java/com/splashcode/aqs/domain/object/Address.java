package com.splashcode.aqs.domain.object;

/**
 * Domain object for an Address
 */

public class Address {
    private final String streetName;
    private final String addressExtension;
    private final String zipcode;
    private final String cityName;
    private final String latitude;
    private final String longitude;

    public Address(final String streetName, final String addressExtension, final String zipcode, final String cityName, final String latitude, final String longitude) {
        this.streetName = streetName;
        this.addressExtension = addressExtension;
        this.zipcode = zipcode;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressExtension() {
        return addressExtension;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
