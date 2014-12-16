package fr.cityway.tagvalidator.ui.main;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import dagger.ObjectGraph;
import fr.cityway.tagvalidator.R;
import fr.cityway.tagvalidator.infrastructure.module.ActivityModule;
import fr.cityway.tagvalidator.infrastructure.provider.UserInfoProvider;
import fr.cityway.tagvalidator.ui.BaseActivity;


public class MainActivity extends BaseActivity { // extends ActionBarActivity

    @Inject UserInfoProvider userInfoProvider;

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
        userInfoProvider.getUserValidationHistory();
    }

    public void fakeMethod() {
        userInfoProvider.getUserValidationHistory();
    }
}
