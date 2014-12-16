package fr.cityway.tagvalidator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * The common activity to all our activities that makes all the dependencies available for use.
 */
public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TagValidatorApplication) getApplication()).inject(this);
    }

    public <T extends View> T findById(int resId) {
        return (T) findViewById(resId);
    }
}
