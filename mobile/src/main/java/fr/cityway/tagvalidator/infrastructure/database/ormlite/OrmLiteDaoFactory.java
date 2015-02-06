package fr.cityway.tagvalidator.infrastructure.database.ormlite;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;

import fr.cityway.tagvalidator.infrastructure.database.Dao;
import fr.cityway.tagvalidator.infrastructure.database.DaoFactory;
import fr.cityway.tagvalidator.infrastructure.database.DatabaseObject;
import fr.cityway.tagvalidator.infrastructure.database.UnrecoverableDbException;

public class OrmLiteDaoFactory implements DaoFactory {
    private final DatabaseHelper databaseHelper;

    public OrmLiteDaoFactory(final DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public <T extends DatabaseObject> Dao<T> getDao(Class<T> clazz) throws UnrecoverableDbException {
        try {
            final TransactionManager manager = new TransactionManager(databaseHelper.getConnectionSource());
            return new OrmLiteDaoAdapter(this.databaseHelper.getDao(clazz), manager);
        } catch (SQLException exception) {
            throw new UnrecoverableDbException("Unknown error while trying to getDao for " + clazz, exception);
        }
    }
}
