import android.app.Application;
import android.graphics.Bitmap;

import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;

import fr.cityway.tagvalidator.ui.TagValidatorApplication;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class RobolectricDaggerTestRunner extends RobolectricTestRunner {

    public RobolectricDaggerTestRunner(final Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return MyTestLifecycle.class;
    }

    public static class MyTestLifecycle extends DefaultTestLifecycle {
        @Override
        public Application createApplication(Method method, AndroidManifest appManifest, Config config) {
            return new TagValidatorApplication();
        }
    }
}
