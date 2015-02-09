package fr.rontho.aqs.infrastructure.database;

import java.sql.SQLException;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class UnrecoverableDbException extends RuntimeException {

    public UnrecoverableDbException() {}

    public UnrecoverableDbException(final String error, final SQLException exception) {
        super(error, exception);
    }
}
