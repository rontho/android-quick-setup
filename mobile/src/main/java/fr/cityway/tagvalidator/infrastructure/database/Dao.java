package fr.cityway.tagvalidator.infrastructure.database;

import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by troncaglia on 06/02/2015.
 */
public interface Dao<T> {
    void create(T var1) throws SQLException;

    void createOrUpdate(T var1) throws SQLException;

    void deleteAll() throws SQLException;

    List<T> getAll() throws SQLException;

    List<T> getByExample(String fieldName, Object value) throws SQLException;

    @Nullable
    T getById(T id);
}
