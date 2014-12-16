import android.location.LocationManager;
import android.widget.TextView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import fr.cityway.tagvalidator.R;
import fr.cityway.tagvalidator.infrastructure.module.ActivityModule;
import fr.cityway.tagvalidator.infrastructure.module.ApplicationModule;
import fr.cityway.tagvalidator.infrastructure.provider.UserInfoProvider;
import fr.cityway.tagvalidator.ui.main.MainActivity;

import static android.content.Context.LOCATION_SERVICE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Robolectric.shadowOf;

/**
 *
 * MainActivity test class. This is just here to validate that Robolectric is working in our project
 *
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest extends TestCase {

    @Inject MainActivity sut;
    private @Mock UserInfoProvider mockUserInfoProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ObjectGraph.create(new TestModule()).inject(this);
    }

    @Test
    public void testMainActivity(){
        MainActivity activity = buildActivity(MainActivity.class).create().start().resume().get();
        TextView mainText = (TextView) activity.findViewById(R.id.main_activity_text);
        assertThat(mainText.getText().toString(), equalTo("Hello world!"));
    }

    @Test
    public void explicitCall(){
        //init
        //ActivityController<MainActivity> activityController = ActivityController.of(sut);

        //run
        // This doesn't work for now...
        //MainActivity activity = activityController.create().start().resume().visible().get();
        sut.fakeMethod();

        //verify
        Mockito.verify(mockUserInfoProvider).getUserValidationHistory();
    }

    @Module(
            includes = {ActivityModule.class},
            injects = MainActivityTest.class,
            complete = false,
            overrides = true,
            library = true
    )
    class TestModule {
        @Provides
        UserInfoProvider provideUserInfoProvider() {
            return mockUserInfoProvider;
        }

        @Provides @Singleton
        LocationManager provideLocationManager() {
            return null;
        }
    }
}