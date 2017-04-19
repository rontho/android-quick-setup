package com.splashcode.aqs.data.database.accessor;

import android.support.annotation.Nullable;

import com.j256.ormlite.misc.TransactionManager;
import com.splashcode.aqs.data.database.DaoFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import com.splashcode.aqs.data.database.Dao;
import com.splashcode.aqs.data.database.UnrecoverableDbException;
import com.splashcode.aqs.data.database.model.SimpleDatabaseData;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class SimpleDataReader {

    private final DaoFactory daoFactory;

    public SimpleDataReader(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<SimpleDatabaseData> getAllSimpleData(){
        final Dao<SimpleDatabaseData> simpleDatabaseDataDao = daoFactory.getDao(SimpleDatabaseData.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            List result = (List)transactionManager.callInTransaction(new Callable() {
                public List<SimpleDatabaseData> call() throws Exception {
                    return simpleDatabaseDataDao.getAll();
                }
            });

            return result;

        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get simple data", e);
        }
    }

    @Nullable
    public SimpleDatabaseData getByMillis(final long value){
        final Dao<SimpleDatabaseData> simpleDatabaseDataDao = daoFactory.getDao(SimpleDatabaseData.class);
        final TransactionManager transactionManager = daoFactory.getTransactionManager();

        try {
            List result = (List)transactionManager.callInTransaction(new Callable() {
                public List<SimpleDatabaseData> call() throws Exception {
                    return simpleDatabaseDataDao.getByExample("millis", value);
                }
            });

            if(result.size() > 0) {
                return (SimpleDatabaseData)result.get(0);
            }

            return null;

        } catch (SQLException e) {
            throw new UnrecoverableDbException("Database error when trying to get simple data", e);
        }
    }
}
