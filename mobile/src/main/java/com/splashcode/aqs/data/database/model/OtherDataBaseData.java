package com.splashcode.aqs.data.database.model;

import com.j256.ormlite.field.DatabaseField;

import com.splashcode.aqs.data.database.DatabaseObject;

/**
 * Created by troncaglia on 06/02/2015.
 */
public class OtherDataBaseData implements DatabaseObject {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String name;

    @Override
    public int getId() {
        return id;
    }
}
