package com.matuszew.braintri_tumblr.common.di.module;

import com.matuszew.braintri_tumblr.login.LoginContract;
import com.matuszew.braintri_tumblr.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by matuszewski on 24/04/2017.
 */

@Module
public abstract class PresenterModule {

    @Binds
    abstract LoginContract.Presenter providesLoginPresenter(LoginPresenter presenter);
}
