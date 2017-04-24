package com.matuszew.braintri_tumblr.login;

import com.matuszew.braintri_tumblr.BasePresenter;

import javax.inject.Inject;

/**
 * Created by matuszewski on 24/04/2017.
 */

public class LoginPresenter extends BasePresenter<LoginContract.ViewModel>
        implements LoginContract.Presenter {


    @Inject
    public LoginPresenter(LoginContract.ViewModel viewModel) {
        super(viewModel);
    }

    @Override
    public void init() {

    }

    @Override
    public void init(Object model) {

    }

    @Override
    public void clear() {

    }
}
