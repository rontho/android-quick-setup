package com.splashcode.aqs.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.splashcode.aqs.presentation.infrastructure.di.ActivityComponent;
import com.splashcode.aqs.presentation.infrastructure.di.ActivityModule;
import com.splashcode.aqs.presentation.infrastructure.di.ApplicationComponent;
import com.splashcode.aqs.presentation.infrastructure.di.DaggerActivityComponent;
import com.splashcode.aqs.presentation.infrastructure.di.HasComponent;
import com.splashcode.aqs.presentation.AndroidQuickSetupApplication;

/**
 * The common activity to all our activities that makes all the dependencies available for use.
 */
public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    protected ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    @Override
    public ActivityComponent getComponent() {
        return activityComponent;
    }

    protected void initializeInjector(){
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidQuickSetupApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
