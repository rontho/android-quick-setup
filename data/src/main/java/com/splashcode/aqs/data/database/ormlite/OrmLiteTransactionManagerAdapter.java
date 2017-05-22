package com.splashcode.aqs.data.database.ormlite;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * Adapter that delegates the call in transaction to the OrmLite Transaction Manager.
 */
public class OrmLiteTransactionManagerAdapter extends TransactionManager {
    private final TransactionManager transactionManager;

    public OrmLiteTransactionManagerAdapter(final TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return this.transactionManager.callInTransaction(callable);
    }
}
