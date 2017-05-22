package com.splashcode.aqs.domain.event.answer;

import com.splashcode.aqs.domain.event.ResponseType;
import com.splashcode.aqs.domain.object.User;

/**
 * Response that contains the answer for the frontend side
 */
public class UserInfoAnswer implements Answer {
    private final ResponseType responseType;
    private final User user;

    public UserInfoAnswer(final ResponseType responseType, final User user) {
        this.responseType = responseType;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public ResponseType getResponseType() {
        return responseType;
    }
}
