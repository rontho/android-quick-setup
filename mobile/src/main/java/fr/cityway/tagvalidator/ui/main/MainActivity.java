package fr.cityway.tagvalidator.ui.main;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import fr.cityway.tagvalidator.R;
import fr.cityway.tagvalidator.infrastructure.annotation.OnlyForTest;
import fr.cityway.tagvalidator.infrastructure.database.Dao;
import fr.cityway.tagvalidator.infrastructure.database.UnrecoverableDbException;
import fr.cityway.tagvalidator.infrastructure.database.accessor.SimpleDataReader;
import fr.cityway.tagvalidator.infrastructure.database.accessor.SimpleDataWriter;
import fr.cityway.tagvalidator.infrastructure.database.model.SimpleDatabaseData;
import fr.cityway.tagvalidator.infrastructure.database.ormlite.DatabaseHelper;
import fr.cityway.tagvalidator.infrastructure.database.ormlite.OrmLiteDaoFactory;
import fr.cityway.tagvalidator.infrastructure.log.Logger;
import fr.cityway.tagvalidator.infrastructure.provider.UserInfoProvider;
import fr.cityway.tagvalidator.ui.BaseActivity;


public class MainActivity extends BaseActivity { // extends ActionBarActivity

    @Inject UserInfoProvider userInfoProvider;
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
        userInfoProvider.getUserValidationHistory();

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
        userInfoProvider.getUserValidationHistory();
    }
}
