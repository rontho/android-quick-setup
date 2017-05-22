package com.splashcode.aqs.data.database.accessor;

import com.j256.ormlite.misc.TransactionManager;
import com.splashcode.aqs.data.database.DaoFactory;
import com.splashcode.aqs.data.database.ormlite.OrmLiteDaoFactory;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import com.splashcode.aqs.data.database.Dao;
import com.splashcode.aqs.data.database.UnrecoverableDbException;
import com.splashcode.aqs.data.database.model.UserDatabaseObject;

/**
 * Persist User data in the local database.
 */
public class UserDataWriter {

    private final DaoFactory daoFactory;

    public UserDataWriter(final DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void storeSimpleData(final UserDatabaseObject userDatabaseObject){
        final Dao<UserDatabaseObject> dao = daoFactory.getDao(UserDatabaseObject.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            transactionManager.callInTransaction(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    dao.createOrUpdate(userDatabaseObject);
                    return null;
                }
            });
        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get create data", e);
        }
    }
}
