package com.matuszew.braintri_tumblr;

/**
 * Created by matuszewski on 24/04/2017.
 */

public abstract class BasePresenter<VM extends BaseViewModelContract> {

    private VM viewModel;

    public BasePresenter(VM viewModel) {
        this.viewModel = viewModel;
        viewModel.setPresenter(this);
    }

    public VM getViewModel() {
        return viewModel;
    }
}
