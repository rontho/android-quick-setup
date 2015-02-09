package fr.cityway.tagvalidator.infrastructure.database.ormlite;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;

import fr.cityway.tagvalidator.infrastructure.database.Dao;
import fr.cityway.tagvalidator.infrastructure.database.DaoFactory;
import fr.cityway.tagvalidator.infrastructure.database.DatabaseObject;
import fr.cityway.tagvalidator.infrastructure.database.UnrecoverableDbException;

public class OrmLiteDaoFactory implements DaoFactory {
    private final DatabaseHelper databaseHelper;
    private final TransactionManager transactionManager;

    public OrmLiteDaoFactory(final DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
        this.transactionManager = new OrmLiteTransactionManagerAdapter(new TransactionManager(databaseHelper.getConnectionSource()));

    }

    public <T extends DatabaseObject> Dao<T> getDao(Class<T> clazz) {
        try {
            return new OrmLiteDaoAdapter(this.databaseHelper.getDao(clazz));
        } catch (SQLException exception) {
            throw new UnrecoverableDbException("Unknown error while trying to getDao for " + clazz, exception);
        }
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
}
