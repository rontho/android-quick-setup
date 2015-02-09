package fr.rontho.aqs.ui.main;

import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.otto.Subscribe;

import javax.inject.Inject;
import javax.inject.Named;

import fr.rontho.aqs.R;
import fr.rontho.aqs.infrastructure.annotation.OnlyForTest;
import fr.rontho.aqs.infrastructure.com.bus.EventBusListener;
import fr.rontho.aqs.infrastructure.com.userinfo.UserInfoAnswer;
import fr.rontho.aqs.infrastructure.database.accessor.SimpleDataReader;
import fr.rontho.aqs.infrastructure.database.accessor.SimpleDataWriter;
import fr.rontho.aqs.infrastructure.database.model.SimpleDatabaseData;
import fr.rontho.aqs.infrastructure.database.ormlite.DatabaseHelper;
import fr.rontho.aqs.infrastructure.database.ormlite.OrmLiteDaoFactory;
import fr.rontho.aqs.infrastructure.log.Logger;
import fr.rontho.aqs.infrastructure.provider.frontend.UserInfoProxy;
import fr.rontho.aqs.ui.BaseActivity;


public class MainActivity extends BaseActivity implements EventBusListener<UserInfoAnswer> { // extends ActionBarActivity

    @Inject @Named("UserInfo")
    UserInfoProxy userInfoProvider;

    @Inject Logger logger;
    @Inject LocationManager locationManager;

    @OnlyForTest
    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger.i("Main Activity resumed");
        userInfoProvider.register(this);
        userInfoProvider.getUserInfo();

        final OrmLiteDaoFactory daoFactory = new OrmLiteDaoFactory(new DatabaseHelper(this));
        final SimpleDataReader simpleDataReader = new SimpleDataReader(daoFactory);
        final SimpleDataWriter simpleDataWriter = new SimpleDataWriter(daoFactory);

        /* This is how you store values in the database */
        simpleDataWriter.storeSimpleData(new SimpleDatabaseData(89777l));

        /* This is how you get values in the database */
        final SimpleDatabaseData simpleDatabaseData = simpleDataReader.getByMilis(89777l);
        Log.d("TEST by Example :: ", simpleDatabaseData.toString());
    }

    public void fakeMethod() {
        userInfoProvider.getUserInfo();
    }

    @Override @Subscribe
    public void onAnswerAvailable(final UserInfoAnswer answer) {
        logger.d("MainActivity", "UserInfoAnswer available");
        userInfoProvider.unregister(this);
    }
}
