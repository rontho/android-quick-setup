package com.splashcode.aqs.data.repository.translator;

import com.splashcode.aqs.data.database.model.UserDatabaseObject;
import com.splashcode.aqs.data.http.response.AddressResponse;
import com.splashcode.aqs.domain.object.Address;
import com.splashcode.aqs.domain.object.builder.AddressBuilder;

/**
 * Translate backend address responses to domain readable object.
 */
public class AddressDataTranslator {
    Address fromHttpResponse(final AddressResponse address) {

        return new AddressBuilder()
                .setStreetName(address.streetName)
                .setAddressExtension(address.addressExtension)
                .setZipcode(address.zipcode)
                .setCityName(address.cityName)
                .setLatitude(address.geoLocation.latitude)
                .setLongitude(address.geoLocation.longitude)
                .createAddress();
    }

    Address fromDatabaseObject(final UserDatabaseObject userDatabaseObject) {

        return new AddressBuilder()
                .setStreetName(userDatabaseObject.streetName)
                .setAddressExtension(userDatabaseObject.addressExtension)
                .setZipcode(userDatabaseObject.zipcode)
                .setCityName(userDatabaseObject.cityName)
                .setLatitude(userDatabaseObject.latitude)
                .setLongitude(userDatabaseObject.longitude)
                .createAddress();
    }
}
