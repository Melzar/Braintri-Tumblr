package com.matuszew.braintri_tumblr;

/**
 * Created by matuszewski on 24/04/2017.
 */

public interface BasePresenterContract<M, VM> {

    void init();

    void init(M model);

    void clear();

    VM getViewModel();

}
