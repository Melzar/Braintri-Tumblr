package com.matuszew.braintri_tumblr.login;

import android.databinding.ObservableField;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.posts.list.PostsListActivity;

import javax.inject.Inject;

/**
 * Created by matuszewski on 24/04/2017.
 */

public class LoginViewModel extends BaseViewModel implements LoginContract.ViewModel {

    ObservableField<String> username = new ObservableField<>();

    @Inject
    public LoginViewModel() {
    }

    @Override
    public void update(Object model) {

    }

    public ObservableField<String> getUsername() {
        return username;
    }

    public void previewPosts(){
        navigator.startActivityTop(PostsListActivity.class);
    }
}
