package com.splashcode.aqs.data.http.retrofit;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.splashcode.aqs.data.http.HttpCallback;
import com.splashcode.aqs.data.http.HttpRequestMaker;
import com.splashcode.aqs.data.http.response.GetUserResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Factory that creates and execute http request using Retrofit and the {@link RetrofitRestApi}
 */
public class RetrofitHttpRequestMaker implements HttpRequestMaker {

    private final RetrofitRestApi retrofitRestApi;

    public RetrofitHttpRequestMaker(final RetrofitRestApi retrofitRestApi) {
        this.retrofitRestApi = retrofitRestApi;
    }

    @Override
    public HttpCallback<GetUserResponse> processGetItineraryResponse(final int userId) throws IOException {
        final Call<GetUserResponse> getUserResponseCall = retrofitRestApi.getUser(userId);
        final Response<GetUserResponse> execute = getUserResponseCall.execute();
        return new RetrofitHttpCallback<>(execute);
    }
}
