package com.splashcode.aqs.domain.repository;

import com.splashcode.aqs.domain.object.User;

/**
 * In the architecture the Providers are here to get data.
 */
public interface UserRepository {
    User getUserData(final int userId);
}
