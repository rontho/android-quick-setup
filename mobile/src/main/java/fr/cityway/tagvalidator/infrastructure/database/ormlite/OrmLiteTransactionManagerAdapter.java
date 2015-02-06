package fr.cityway.tagvalidator.infrastructure.database.ormlite;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * Created by troncaglia on 06/02/2015.
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
