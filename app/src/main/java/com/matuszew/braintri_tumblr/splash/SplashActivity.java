package com.matuszew.braintri_tumblr.splash;

import android.os.Bundle;

import com.matuszew.braintri_tumblr.BaseActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashContract.Presenter> {

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
}
