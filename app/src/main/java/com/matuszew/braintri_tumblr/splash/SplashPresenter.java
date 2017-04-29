package com.matuszew.braintri_tumblr.splash;

import com.matuszew.braintri_tumblr.BasePresenter;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class SplashPresenter
        extends BasePresenter<SplashContract.ViewModel> implements SplashContract.Presenter {

    @Inject
    public SplashPresenter(SplashContract.ViewModel viewModel) {
        super(viewModel);
    }

    @Override
    public void init() {

    }

    @Override
    public void init(Void model) {
        getViewModel().update(null);
    }

    @Override
    public void clear() {

    }
}
