package com.splashcode.aqs.data.http.retrofit;

import com.splashcode.aqs.data.http.HttpCallback;

import retrofit2.Response;

/**
 * Retofit implementation of the {@link HttpCallback} interface.
 */
public class RetrofitHttpCallback<T> implements HttpCallback<T> {

    private final Response<T> response;

    public RetrofitHttpCallback(final Response<T> response) {
        this.response = response;
    }

    @Override
    public boolean isSuccess(){
        return response.isSuccessful();
    }

    @Override
    public T getBody() {
        return response.body();
    }

    @Override
    public int getCode() {
        return response.code();
    }

    @Override
    public String getMessage() {
        return response.message();
    }
}
