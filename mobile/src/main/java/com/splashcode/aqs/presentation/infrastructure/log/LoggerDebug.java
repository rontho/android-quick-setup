package com.splashcode.aqs.presentation.infrastructure.log;

import android.util.Log;

/**
 * A debug version of the logger that log the message using the Android Logger
 */
public class LoggerDebug implements Logger {

    private static final String DEFAULT_TAG = "DEFAULT-TAG";

    @Override
    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void i(String message) {
        Log.i(DEFAULT_TAG, message);
    }

    @Override
    public void i(final String tag, final String message) {
        Log.i(tag, message);
    }

    @Override
    public void e(final String tag, final String message, final Throwable throwable) {
        Log.e(tag, message, throwable);
    }
}
