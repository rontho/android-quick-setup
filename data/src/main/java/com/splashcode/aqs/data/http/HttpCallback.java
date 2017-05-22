package com.splashcode.aqs.data.http;

/**
 * Interface to communicate with a http callback in order to get the body, the code and the message.
 */
public interface HttpCallback<T> {
    boolean isSuccess();
    T getBody();
    int getCode();
    String getMessage();
}
