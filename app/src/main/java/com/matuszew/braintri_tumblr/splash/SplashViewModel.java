package com.matuszew.braintri_tumblr.splash;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.util.SessionUtil;
import com.matuszew.braintri_tumblr.login.LoginActivity;
import com.matuszew.braintri_tumblr.posts.list.PostsListActivity;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class SplashViewModel
        extends BaseViewModel<Void, SplashContract.Presenter> implements SplashContract.ViewModel {

    @Inject
    public SplashViewModel() {
    }

    @Override
    protected void init() {
            navigator.startActivityTop(SessionUtil
                    .getSessionValue(R.string.tumblr_user_session) != null ?
                    PostsListActivity.class : LoginActivity.class);
    }
}
