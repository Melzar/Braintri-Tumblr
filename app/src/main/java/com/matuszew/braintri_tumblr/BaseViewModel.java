package com.matuszew.braintri_tumblr;

import android.databinding.BaseObservable;

/**
 * Created by matuszewski on 24/04/2017.
 */

public abstract class BaseViewModel<M> extends BaseObservable {

    private M model;

    public BaseViewModel() {
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
