package com.splashcode.aqs.domain.event.answer;

import com.splashcode.aqs.domain.event.ResponseType;

/**
 * Object to be posted to the EventBus
 */
public interface Answer {
    ResponseType getResponseType();
}
