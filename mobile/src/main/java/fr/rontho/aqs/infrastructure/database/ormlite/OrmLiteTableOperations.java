package fr.rontho.aqs.infrastructure.database.ormlite;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import fr.rontho.aqs.infrastructure.database.TableOperations;

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
