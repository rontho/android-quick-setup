package fr.rontho.aqs.infrastructure.database.ormlite;

import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

import fr.rontho.aqs.infrastructure.database.Dao;
import fr.rontho.aqs.infrastructure.database.DatabaseObject;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class OrmLiteDaoAdapter <T extends DatabaseObject> implements Dao<T> {

    private final com.j256.ormlite.dao.Dao<T,java.lang.Integer> realDao;

    public OrmLiteDaoAdapter (final com.j256.ormlite.dao.Dao<T , Integer> dao) {
        this.realDao = dao;
    }

    @Override
    public void create(final T databaseObject) throws SQLException {
        realDao.create(databaseObject);
    }

    @Override
    public void createOrUpdate(T databaseObject) throws SQLException {
        realDao.createOrUpdate(databaseObject);
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
    public List<T> getByExample(final String fieldName, final Object value) throws SQLException {
        return realDao.queryForEq(fieldName, value);
    }

    @Nullable
    @Override
    public T getById(T databaseObject) throws SQLException {
        return realDao.queryForId(databaseObject.getId());
    }
}
