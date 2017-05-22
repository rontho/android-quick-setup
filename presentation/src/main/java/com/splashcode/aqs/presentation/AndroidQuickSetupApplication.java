package com.splashcode.aqs.presentation;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.splashcode.aqs.presentation.infrastructure.di.ApplicationComponent;
import com.splashcode.aqs.presentation.infrastructure.di.ApplicationModule;
import com.splashcode.aqs.presentation.infrastructure.di.DaggerApplicationComponent;

/**
 * This is the main Application class, it allows us to is used to create and manage a global object
 * graph of objects. Modules are assembled with the getModules() method that can be overridden to
 * add additional modules.
 *
 * TODO Change the name to match you Application name
 */
public class AndroidQuickSetupApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
        MultiDex.install(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }
}
