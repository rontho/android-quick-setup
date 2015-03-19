import android.location.LocationManager;
import android.widget.TextView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.rontho.aqs.R;
import fr.rontho.aqs.infrastructure.provider.frontend.UserInfoProxy;
import fr.rontho.aqs.ui.AndroidQuickSetupApplication;
import fr.rontho.aqs.ui.main.MainActivity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
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

//    @Inject MainActivity sut;
    private @Mock
UserInfoProxy mockUserInfoProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //ObjectGraph.create(new TestModule()).inject(this);
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
        //MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();

        ((AndroidQuickSetupApplication)Robolectric.application).inject(new TestModule());
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();

        //run
        // This doesn't work for now...
        //MainActivity activity = activityController.create().start().resume().visible().get();
        activity.fakeMethod();

        //verify
        Mockito.verify(mockUserInfoProvider).getUserInfo();
    }

    @Module(
            injects = MainActivity.class,
            complete = false,
            library = true
    )
    class TestModule {
        @Provides
        UserInfoProxy provideUserInfoProvider() {
            return mockUserInfoProvider;
        }

        @Provides @Singleton
        LocationManager provideLocationManager() {
            return null;
        }
    }
}