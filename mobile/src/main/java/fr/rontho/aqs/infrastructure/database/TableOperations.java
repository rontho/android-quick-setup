package fr.rontho.aqs.infrastructure.database;

import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public interface TableOperations {
    void createTableIfNotExists(ConnectionSource connectionSource, Class<?> clazz) throws SQLException;
    void dropTable(ConnectionSource connectionSource, Class<?> clazz, boolean aBoolean) throws SQLException;
}
