package fr.cityway.tagvalidator.infrastructure.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.cityway.tagvalidator.infrastructure.provider.UserInfoProvider;
import fr.cityway.tagvalidator.infrastructure.provider.frontend.UserInfoProviderProxy;
import fr.cityway.tagvalidator.ui.main.MainActivity;

/**
 * Created by troncaglia on 15/12/2014.
 */
@Module (library = true,
         injects = MainActivity.class)
public class ActivityModule {

    @Provides
    UserInfoProvider provideUserInfoProvider(){
        return new UserInfoProviderProxy();
    }
}
