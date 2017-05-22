package com.splashcode.aqs.data.database.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.splashcode.aqs.data.database.DatabaseObject;
import com.splashcode.aqs.data.database.TableOperations;
import com.splashcode.aqs.data.database.model.UserDatabaseObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The DatabaseHelper is here to define the structure of the database. It defines it's name, version
 * number and all the table it contains. It can also be used to define upGrade strategies. For now
 * when we increment the database number, we will simply drop all the tables and recreate the database
 * from scratch (all the data are lost).
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "application_database_name.db";
    private static final int DATABASE_VERSION = 1;

    private final List<Class<? extends DatabaseObject>> tableList = new ArrayList<>();
    private final TableOperations tableOperations;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.tableOperations = new OrmLiteTableOperations();
        tableList.add(UserDatabaseObject.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            for (Class<? extends DatabaseObject> dataBaseTable : tableList) {
                tableOperations.createTableIfNotExists(connectionSource, dataBaseTable);
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            for (Class<? extends DatabaseObject> dataBaseTable : tableList) {
                tableOperations.dropTable(connectionSource, dataBaseTable, true);
                onCreate(db, connectionSource);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
