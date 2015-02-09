package fr.rontho.aqs.infrastructure.database.model;

import com.j256.ormlite.field.DatabaseField;

import fr.rontho.aqs.infrastructure.database.DatabaseObject;

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
