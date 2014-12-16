import org.robolectric.TestLifecycleApplication;

import java.lang.reflect.Method;

import fr.cityway.tagvalidator.ui.TagValidatorApplication;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class TestApplication extends TagValidatorApplication implements TestLifecycleApplication {
    @Override
    public void beforeTest(Method method) {

    }

    @Override
    public void prepareTest(Object test) {

    }

    @Override
    public void afterTest(Method method) {

    }
}
