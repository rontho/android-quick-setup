package fr.cityway.tagvalidator.infrastructure.database.ormlite;

import android.support.annotation.Nullable;

import com.j256.ormlite.misc.TransactionManager;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import fr.cityway.tagvalidator.infrastructure.database.Dao;
import fr.cityway.tagvalidator.infrastructure.database.DatabaseObject;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class OrmLiteDaoAdapter <T extends DatabaseObject> implements Dao<T> {

    private final com.j256.ormlite.dao.Dao<T,java.lang.Integer> realDao;
    private final TransactionManager transactionManager;

    public OrmLiteDaoAdapter (final com.j256.ormlite.dao.Dao<T , Integer> dao, final TransactionManager manager) {
        this.realDao = dao;
        this.transactionManager = new OrmLiteTransactionManagerAdapter(manager);
    }

    @Override
    public void create(final T databaseRow) throws SQLException {
        transactionManager.callInTransaction(new Callable() {
            public Void call() throws Exception {
                realDao.create(databaseRow);
                return null;
            }
        });
    }

    @Override
    public void createOrUpdate(T databaseRow) throws SQLException {
        realDao.createOrUpdate(databaseRow);
    }

    @Override
    public void deleteAll() throws SQLException {
        for (T row : getAll()) {
            realDao.delete(row);
        }
    }

    @Override
    public List<T> getAll() throws SQLException {
        return realDao.queryForAll();
    }

    @Override
    public List<T> getByExample(String fieldName, Object value) throws SQLException {
        return realDao.queryForEq(fieldName, value);
    }

    @Nullable
    @Override
    public T getById(T id) {
        return null;
    }
}
