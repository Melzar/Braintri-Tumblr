package com.matuszew.braintri_tumblr;

import android.databinding.BaseObservable;

import com.matuszew.braintri_tumblr.common.helper.Navigator;

import javax.inject.Inject;

/**
 * Created by matuszewski on 24/04/2017.
 */

public abstract class BaseViewModel<M, P> extends BaseObservable {

    @Inject
    protected Navigator navigator;

    private M model;

    private P presenter;

    public BaseViewModel() {
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public void update(M model){
        this.model = model;
        init();
        notifyChange();
    }

    protected abstract void init();
}
