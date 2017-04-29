package com.matuszew.braintri_tumblr.splash;

import android.os.Bundle;
import android.os.Handler;

import com.matuszew.braintri_tumblr.BaseActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.databinding.ActivitySplashBinding;

import javax.inject.Inject;

public class SplashActivity
        extends BaseActivity<ActivitySplashBinding, SplashContract.Presenter> implements Runnable  {

    @Inject
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityLayout() {
        setActivityLayoutAndBinding(R.layout.activity_splash);
    }

    @Override
    protected void injectDependencies(ActivitySubComponent activitySubComponent) {
        activitySubComponent.inject(this);
    }

    @Override
    public void run() {
        presenter.init(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(this, getResources().getInteger(R.integer.splash_delay_timeout));
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(this);
    }
}