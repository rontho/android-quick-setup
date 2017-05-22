package com.splashcode.aqs.data.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * Server response for a geo location object.
 */
public class GeoLocationResponse {
    @SerializedName ("lat")
    public String latitude;
    @SerializedName("lng")
    public String longitude;
}
