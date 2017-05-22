package com.splashcode.aqs.data.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * This a the schema of the User response. We are using Gson to desezialized it in retrofit.
 * Here is the url used to get the response format {@link : https://jsonplaceholder.typicode.com/users/1}
 */
public class GetUserResponse {
    @SerializedName("username")
    public String userName;
    @SerializedName("email")
    public String email;
    @SerializedName("address")
    public AddressResponse address;
    @SerializedName("phone")
    public String phone;
    @SerializedName("website")
    public String website;
    @SerializedName("company")
    public CompanyResponse company;
}
