package com.splashcode.aqs.data.http.retrofit;

import com.splashcode.aqs.data.http.response.GetUserResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit rest api.
 */
public interface RetrofitRestApi {
    @GET ("/users/{id}")
    Call<GetUserResponse> getUser(@Path("id") final int userId) throws IOException;
}
