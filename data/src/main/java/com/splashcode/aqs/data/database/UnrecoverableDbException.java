package com.splashcode.aqs.data.database;

import java.sql.SQLException;

/**
 * Exception that encapsulate a RuntimeException when a database error occurs.
 */
public class UnrecoverableDbException extends RuntimeException {

    public UnrecoverableDbException(final String error, final SQLException exception) {
        super(error, exception);
    }
}
