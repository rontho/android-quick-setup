import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.splashcode.aqs.data.eventbus.EventBus;
import com.splashcode.aqs.data.repository.backend.BackEndDataProviderFactory;
import com.splashcode.aqs.presentation.infrastructure.frontend.UserInfoProviderProxy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 *
 * This test class is a dummy one, we are just validating the Junit, Gradle + AndroidStudio integration
 *
 */
public class UserInfoProviderProxyTest extends TestCase {

    private UserInfoProviderProxy sut;
    @Mock
    EventBus mockEventBus;
    @Mock BackEndDataProviderFactory mockEventBusResponseProviderFactory;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new UserInfoProviderProxy(mockEventBus, mockEventBusResponseProviderFactory);
    }

    @Test
    public void testGetValuePlusOne() throws Exception {
        //init

        //run
        int expected = sut.fakeMethodOnlyForTest(1);

        //verify
        assertThat(expected, equalTo(2));
    }
}