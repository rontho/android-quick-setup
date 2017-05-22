package com.splashcode.aqs.presentation.infrastructure.di;

import android.app.Activity;

import com.splashcode.aqs.presentation.infrastructure.annotation.PerActivity;
import com.splashcode.aqs.presentation.view.BaseActivity;
import com.splashcode.aqs.presentation.view.activity.MainActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(final BaseActivity baseActivity);
    void inject(final MainActivity mainActivity);
    //Exposed to sub-graphs.
    Activity activity();
}
