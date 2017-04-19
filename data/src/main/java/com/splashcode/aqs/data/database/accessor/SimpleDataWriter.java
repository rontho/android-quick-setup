package com.splashcode.aqs.data.database.accessor;

import com.j256.ormlite.misc.TransactionManager;
import com.splashcode.aqs.data.database.ormlite.OrmLiteDaoFactory;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import com.splashcode.aqs.data.database.Dao;
import com.splashcode.aqs.data.database.UnrecoverableDbException;
import com.splashcode.aqs.data.database.model.SimpleDatabaseData;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class SimpleDataWriter {

    private final OrmLiteDaoFactory daoFactory;

    public SimpleDataWriter(final OrmLiteDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void storeSimpleData(final SimpleDatabaseData simpleDatabaseData){
        final Dao<SimpleDatabaseData> dao = daoFactory.getDao(SimpleDatabaseData.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            transactionManager.callInTransaction(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    dao.createOrUpdate(simpleDatabaseData);
                    return null;
                }
            });
        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get create data", e);
        }
    }
}
