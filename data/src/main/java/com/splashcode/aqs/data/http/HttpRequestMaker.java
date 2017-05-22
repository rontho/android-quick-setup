package com.splashcode.aqs.data.http;

import com.splashcode.aqs.data.http.response.GetUserResponse;

import java.io.IOException;

/**
 * This interface represent all the http request you can make from the app. If this become too big
 * at some point, you can chose to split it by features or group of features.
 */
public interface HttpRequestMaker {
    HttpCallback<GetUserResponse> processGetItineraryResponse(final int userId) throws IOException;
}
