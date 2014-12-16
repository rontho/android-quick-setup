package fr.cityway.tagvalidator.infrastructure.provider.frontend;

import fr.cityway.tagvalidator.infrastructure.provider.UserInfoProvider;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class UserInfoProviderProxy implements UserInfoProvider {
    @Override
    public void getUserValidationHistory() {
        //TODO Thomas
    }

    public int fakeMethodOnlyForTest(final int value){
        return value + 1;
    }
}
