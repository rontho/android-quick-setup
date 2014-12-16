package fr.cityway.tagvalidator.ui;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import fr.cityway.tagvalidator.infrastructure.module.ActivityModule;
import fr.cityway.tagvalidator.infrastructure.module.ApplicationModule;

/**
 * This is the main Application class, it allows us to is used to create and manage a global object
 * graph of objects. Modules are assembled with the getModules() method that can be overridden to
 * add additional modules.
 */
public class TagValidatorApplication extends Application {

    private ObjectGraph graph;

    @Override public void onCreate() {
        super.onCreate();
        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new ApplicationModule(this),
                new ActivityModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
