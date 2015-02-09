package fr.rontho.aqs.infrastructure.database;

import android.support.annotation.Nullable;

import java.sql.SQLException;
import java.util.List;

/**
 * The DAO gives you access to a database table. You can create a new raw, update it, delete all the
 * values in the table or get access to all the elements, or specific element by example or id.
 */
public interface Dao<T> {
    void create(T databaseObject) throws SQLException;

    void createOrUpdate(T databaseObject) throws SQLException;

    void deleteAll() throws SQLException;

    List<T> getAll() throws SQLException;

    List<T> getByExample(String fieldName, Object value) throws SQLException;

    @Nullable
    T getById(T id) throws SQLException;
}
