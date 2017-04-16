package com.splashcode.aqs.presentation.infrastructure.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

import com.splashcode.aqs.presentation.infrastructure.log.Logger;
import com.splashcode.aqs.presentation.AndroidQuickSetupApplication;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidQuickSetupApplication application);

    //Exposed to sub-graphs.
    Context context();
}