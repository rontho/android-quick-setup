package com.splashcode.aqs.data.database;

import com.j256.ormlite.misc.TransactionManager;

/**
 * Interface definition to create a DaoFactory.
 */
public interface DaoFactory {
    <T extends DatabaseObject> Dao<T> getDao(Class<T> clazz) throws UnrecoverableDbException;
    TransactionManager getTransactionManager();
}
