package com.matuszew.braintri_tumblr.login;

import android.databinding.ObservableField;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.util.SessionUtil;
import com.matuszew.braintri_tumblr.posts.list.PostsListActivity;

import javax.inject.Inject;

/**
 * Created by matuszewski on 24/04/2017.
 */

public class LoginViewModel
        extends BaseViewModel<Object, LoginContract.Presenter> implements LoginContract.ViewModel {

    ObservableField<String> username = new ObservableField<>();

    @Inject
    public LoginViewModel() {
    }

    @Override
    protected void init() {

    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void previewPosts(){
        SessionUtil.addItemToSession(R.string.tumblr_user_session, username.get());
        navigator.startActivityTop(PostsListActivity.class);
    }
}
