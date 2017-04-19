package com.splashcode.aqs.data.database.ormlite;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.splashcode.aqs.data.database.TableOperations;

import java.sql.SQLException;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class OrmLiteTableOperations implements TableOperations {
    public OrmLiteTableOperations() {
    }

    @Override
    public void createTableIfNotExists(ConnectionSource connectionSource, Class<?> clazz) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, clazz);
    }

    @Override
    public void dropTable(ConnectionSource connectionSource, Class<?> clazz, boolean ignoreErrors) throws SQLException {
        TableUtils.dropTable(connectionSource, clazz, ignoreErrors);
    }
}
