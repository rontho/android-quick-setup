package com.splashcode.aqs.data.repository.translator;

import com.splashcode.aqs.data.database.model.UserDatabaseObject;
import com.splashcode.aqs.data.http.response.GetUserResponse;
import com.splashcode.aqs.domain.object.Address;
import com.splashcode.aqs.domain.object.Company;
import com.splashcode.aqs.domain.object.User;
import com.splashcode.aqs.domain.object.builder.UserBuilder;

/**
 * The translators allows us to transform backend response (http, database, cached in file system)
 * to domain readable object.
 * This object will usually contains the domain object,
 * the request status (failed, success, http error...)
 * and other usefull information we will need on the front end side.
 */
public class UserDataTranslator {

    private AddressDataTranslator addressDataTranslator;
    private CompanyDataTranslator companyDataTranslator;

    public UserDataTranslator(final AddressDataTranslator addressDataTranslator, final CompanyDataTranslator companyDataTranslator) {
        this.addressDataTranslator = addressDataTranslator;
        this.companyDataTranslator = companyDataTranslator;
    }

    public User translateFromHttp(final GetUserResponse getUserResponse) {
        final Address address = addressDataTranslator.fromHttpResponse(getUserResponse.address);
        final Company company = companyDataTranslator.fromHttpResponse(getUserResponse.company);
        return new UserBuilder().setUserName(getUserResponse.userName).setPhone(getUserResponse.phone)
                .setEmail(getUserResponse.email).setAddress(address).setCompany(company).createUser();
    }

    public User translateFromDatabaseObject(final UserDatabaseObject userDatabaseObject) {
        final String userName = userDatabaseObject.userName;
        final String userPhone = userDatabaseObject.userPhone;
        final String userEmail = userDatabaseObject.userEmail;

        final Address address = addressDataTranslator.fromDatabaseObject(userDatabaseObject);
        final Company company = companyDataTranslator.fromDatabaseObject(userDatabaseObject);

        return new User(userName, userPhone, userEmail, address, company);
    }

    public UserDatabaseObject translateToDatabaseObject(final User user) {
        UserDatabaseObject userDatabaseObject = new UserDatabaseObject();
        userDatabaseObject.userName = user.getUserName();
        return userDatabaseObject;
    }
}
