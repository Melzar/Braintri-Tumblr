package com.matuszew.braintri_tumblr;

import android.databinding.Observable;

/**
 * Created by matuszewski on 24/04/2017.
 */

public interface BaseViewModelContract<M, P> extends Observable {

    void update(M model);

    void setPresenter(P presenter);

    M getModel();
}
