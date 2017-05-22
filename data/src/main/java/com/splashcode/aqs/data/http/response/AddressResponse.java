package com.splashcode.aqs.data.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * Server response for a address object.
 */
public class AddressResponse {
    @SerializedName ("street")
    public String streetName;
    @SerializedName("suite")
    public String addressExtension;
    @SerializedName("city")
    public String cityName;
    @SerializedName("zipcode")
    public String zipcode;
    @SerializedName("geo")
    public GeoLocationResponse geoLocation;
}
