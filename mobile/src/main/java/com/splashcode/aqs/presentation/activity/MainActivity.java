package com.splashcode.aqs.presentation.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.common.eventbus.Subscribe;
import com.splashcode.aqs.R;
import com.splashcode.aqs.presentation.infrastructure.log.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import com.splashcode.aqs.presentation.infrastructure.annotation.OnlyForTest;
import com.splashcode.aqs.data.event.userinfo.UserInfoAnswer;
import com.splashcode.aqs.data.database.accessor.SimpleDataReader;
import com.splashcode.aqs.data.database.accessor.SimpleDataWriter;
import com.splashcode.aqs.data.database.model.SimpleDatabaseData;
import com.splashcode.aqs.data.database.ormlite.DatabaseHelper;
import com.splashcode.aqs.data.database.ormlite.OrmLiteDaoFactory;
import com.splashcode.aqs.presentation.infrastructure.frontend.UserInfoProxy;
import com.splashcode.aqs.presentation.model.MainActivityViewModel;
import com.splashcode.aqs.presentation.presenter.MainActivityPresenter;
import com.splashcode.aqs.presentation.view.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BindableView<MainActivityViewModel> {

    @Inject Logger logger;
    @Inject MainActivityPresenter presenter;

    @OnlyForTest
    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectDependencies();

    }

    private void injectDependencies() {
        ButterKnife.bind(this);
        activityComponent.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
        final SimpleDatabaseData simpleDatabaseData = simpleDataReader.getByMillis(89777l);
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

    @Override
    public void bind(final MainActivityViewModel viewModel) {
        //Bind the model to the view here
    }
}
