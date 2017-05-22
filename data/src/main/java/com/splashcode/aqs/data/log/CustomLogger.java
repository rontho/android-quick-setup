package com.splashcode.aqs.data.log;

/**
 * Wrapper around the Android Logger that allow us to activate and de-activate the log for debug and release purposes.
 */
public interface CustomLogger {
    void d(final String tag, final String message);
    void i(final String message);
    void i(final String tag, final String message);
    void e(final String tag, final String message, final Throwable throwable);
}
