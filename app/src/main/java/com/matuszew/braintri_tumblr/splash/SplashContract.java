package com.matuszew.braintri_tumblr.splash;

import com.matuszew.braintri_tumblr.BasePresenterContract;
import com.matuszew.braintri_tumblr.BaseViewModelContract;

/**
 * Created by matuszewski on 27/04/2017.
 */

public interface SplashContract {

    interface Presenter extends BasePresenterContract<Void, ViewModel>{

    }

    interface ViewModel extends BaseViewModelContract<Void, Presenter>{

    }
}
