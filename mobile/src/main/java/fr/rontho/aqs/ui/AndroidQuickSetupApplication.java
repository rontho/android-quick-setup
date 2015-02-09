package fr.rontho.aqs.ui;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import fr.rontho.aqs.infrastructure.module.ActivityModule;
import fr.rontho.aqs.infrastructure.module.ApplicationModule;

/**
 * This is the main Application class, it allows us to is used to create and manage a global object
 * graph of objects. Modules are assembled with the getModules() method that can be overridden to
 * add additional modules.
 *
 * TODO Change the name to match you Application name
 */
public class AndroidQuickSetupApplication extends Application {

    public static final Bus eventBus = new Bus(ThreadEnforcer.ANY);

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
