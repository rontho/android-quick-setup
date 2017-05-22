package com.splashcode.aqs.data.database.accessor;

import com.j256.ormlite.misc.TransactionManager;
import com.splashcode.aqs.data.database.Dao;
import com.splashcode.aqs.data.database.DaoFactory;
import com.splashcode.aqs.data.database.UnrecoverableDbException;
import com.splashcode.aqs.data.database.model.UserDatabaseObject;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Database accessor for a User object.
 */
public class UserDataReader {

    private final DaoFactory daoFactory;

    public UserDataReader(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<UserDatabaseObject> getAllSimpleData(){
        final Dao<UserDatabaseObject> simpleDatabaseDataDao = daoFactory.getDao(UserDatabaseObject.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            return (List)transactionManager.callInTransaction(new Callable() {
                public List<UserDatabaseObject> call() throws Exception {
                    return simpleDatabaseDataDao.getAll();
                }
            });

        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get simple data", e);
        }
    }

    public UserDatabaseObject getById(final int userId) {
        final Dao<UserDatabaseObject> simpleDatabaseDataDao = daoFactory.getDao(UserDatabaseObject.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            List result = (List)transactionManager.callInTransaction(new Callable() {
                public List<UserDatabaseObject> call() throws Exception {
                    return simpleDatabaseDataDao.getByExample("millis", userId);
                }
            });

            if(result.size() > 0) {
                return (UserDatabaseObject)result.get(0);
            }

            return null;

        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get simple data", e);
        }
    }
}
