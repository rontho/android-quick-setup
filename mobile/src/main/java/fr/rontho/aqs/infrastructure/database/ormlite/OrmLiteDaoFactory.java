package fr.rontho.aqs.infrastructure.database.ormlite;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;

import fr.rontho.aqs.infrastructure.database.Dao;
import fr.rontho.aqs.infrastructure.database.DaoFactory;
import fr.rontho.aqs.infrastructure.database.DatabaseObject;
import fr.rontho.aqs.infrastructure.database.UnrecoverableDbException;

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
