package com.splashcode.aqs.domain.event.answer;

import com.splashcode.aqs.domain.event.ResponseType;
import com.splashcode.aqs.domain.object.User;

/**
 * Create Answer Object that can be passed to the event Bus.
 */

public class AnswerFactory {
    public Answer createGetUserAnswer(final ResponseType responseType, final User localUserData) {
        return new UserInfoAnswer(responseType, localUserData);
    }
}
