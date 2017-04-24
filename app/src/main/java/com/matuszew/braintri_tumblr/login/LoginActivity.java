package com.matuszew.braintri_tumblr.login;

import android.os.Bundle;

import com.matuszew.braintri_tumblr.BaseActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginContract.Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityLayoutAndBinding(R.layout.activity_login);
    }

    @Override
    protected void injectDependencies(ActivitySubComponent activitySubComponent) {
        activitySubComponent.inject(this);
    }
}
