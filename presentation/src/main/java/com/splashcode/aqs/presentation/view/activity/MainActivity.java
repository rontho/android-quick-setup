package com.splashcode.aqs.presentation.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.common.eventbus.Subscribe;
import com.splashcode.aqs.R;
import com.splashcode.aqs.data.log.CustomLogger;

import javax.inject.Inject;

import com.splashcode.aqs.presentation.infrastructure.annotation.OnlyForTest;
import com.splashcode.aqs.domain.event.answer.UserInfoAnswer;
import com.splashcode.aqs.presentation.model.MainActivityViewModel;
import com.splashcode.aqs.presentation.presenter.MainActivityPresenter;
import com.splashcode.aqs.presentation.view.BaseActivity;
import com.splashcode.aqs.presentation.view.MainActivityView;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainActivityView {

    @Inject CustomLogger customLogger;
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
        presenter.init(this);
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
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void bind(final MainActivityViewModel viewModel) {
        //Bind the model to the view here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.release();
    }
}
