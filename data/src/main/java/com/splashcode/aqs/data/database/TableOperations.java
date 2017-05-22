package com.splashcode.aqs.data.database;

import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 * Define a common interface that list the available operation on a Database Table.
 */
public interface TableOperations {
    void createTableIfNotExists(ConnectionSource connectionSource, Class<?> clazz) throws SQLException;
    void dropTable(ConnectionSource connectionSource, Class<?> clazz, boolean aBoolean) throws SQLException;
}
