package fr.rontho.aqs.infrastructure.database;

import com.j256.ormlite.misc.TransactionManager;

/**
 * Created by troncaglia on 06/02/2015.
 */
public interface DaoFactory {
    <T extends DatabaseObject> Dao<T> getDao(Class<T> clazz) throws UnrecoverableDbException;
    TransactionManager getTransactionManager();
}
