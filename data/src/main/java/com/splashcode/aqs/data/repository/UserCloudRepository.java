package com.splashcode.aqs.data.repository;

import android.support.annotation.Nullable;

import com.splashcode.aqs.data.log.CustomLogger;
import com.splashcode.aqs.data.http.HttpCallback;
import com.splashcode.aqs.data.http.HttpRequestMaker;
import com.splashcode.aqs.data.http.response.GetUserResponse;
import com.splashcode.aqs.data.repository.translator.UserDataTranslator;
import com.splashcode.aqs.domain.object.User;
import com.splashcode.aqs.domain.repository.UserRepository;

import java.io.IOException;

/**
 * This web implementation will use the
 * HttpRequestMaker to get data from a web service and send back the result the calling object
 * synchronously.
 */
public class UserCloudRepository implements UserRepository {

    private static final String TAG = UserCloudRepository.class.getSimpleName();

    private final CustomLogger logger;
    private final HttpRequestMaker httpRequestMaker;
    private final UserDataTranslator userDataTranslator;

    public UserCloudRepository(final CustomLogger logger, final HttpRequestMaker httpRequestMaker, final UserDataTranslator userDataTranslator) {
        this.logger = logger;
        this.httpRequestMaker = httpRequestMaker;
        this.userDataTranslator = userDataTranslator;
    }

    @Override @Nullable
    public User getUserData(final int userId) {
        try {
            HttpCallback<GetUserResponse> getUserResponseHttpCallback = httpRequestMaker.processGetItineraryResponse(userId);
            GetUserResponse getUserResponse = getUserResponseHttpCallback.getBody();
            return userDataTranslator.translateFromHttp(getUserResponse);
        } catch (IOException e) {
            logger.e(TAG, "Error while getting the user response data", e);
        }
        return null;
    }
}
