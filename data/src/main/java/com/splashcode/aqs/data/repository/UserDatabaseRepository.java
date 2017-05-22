package com.splashcode.aqs.data.repository;

import com.splashcode.aqs.data.database.accessor.UserDataReader;
import com.splashcode.aqs.data.database.accessor.UserDataWriter;
import com.splashcode.aqs.data.database.model.UserDatabaseObject;
import com.splashcode.aqs.data.repository.translator.UserDataTranslator;
import com.splashcode.aqs.domain.object.User;
import com.splashcode.aqs.domain.repository.UserRepository;

/**
 * Gives access to user data stored in local database.
 */
public class UserDatabaseRepository implements UserRepository {

    final UserDataReader userDataReader;
    final UserDataWriter userDataWriter;
    private UserDataTranslator userDataTranslator;

    public UserDatabaseRepository(final UserDataReader userDataReader,
                                  final UserDataWriter userDataWriter,
                                  final UserDataTranslator userDataTranslator) {
        this.userDataReader = userDataReader;
        this.userDataWriter = userDataWriter;
        this.userDataTranslator = userDataTranslator;
    }

    @Override
    public User getUserData(final int userId) {
        /* This is how you get values in the database */
        final UserDatabaseObject userDatabaseObject = userDataReader.getById(userId);
        if(userDatabaseObject != null) {
            return userDataTranslator.translateFromDatabaseObject(userDatabaseObject);
        }
        return User.EMPTY;
    }

    public void storeUserData(final User user) {
        UserDatabaseObject userDatabaseObject = userDataTranslator.translateToDatabaseObject(user);
        userDataWriter.storeSimpleData(userDatabaseObject);
    }
}
