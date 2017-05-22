package com.splashcode.aqs.data.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * Server response for a Company object. You can notice here that the name we use for our field
 * are different from the one sent by the server. This is good when facing meaningless name like "bs"
 * here for instance. This kind of practice is sometimes referred as an anti-corruption layer.
 */
public class CompanyResponse {
    @SerializedName ("name")
    public String companyName;
    @SerializedName("catchPhrase")
    public String companyCatchPhrase;
    @SerializedName("bs")
    public String companyBaseLine;
}
