package fr.cityway.tagvalidator.infrastructure.database.ormlite;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class TableOperationsImpl implements TableOperations {
    public TableOperationsImpl() {
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
