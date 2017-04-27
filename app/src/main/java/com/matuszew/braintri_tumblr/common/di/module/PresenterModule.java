package com.matuszew.braintri_tumblr.common.di.module;

import com.matuszew.braintri_tumblr.login.LoginContract;
import com.matuszew.braintri_tumblr.login.LoginPresenter;
import com.matuszew.braintri_tumblr.posts.details.PostDetailsContract;
import com.matuszew.braintri_tumblr.posts.details.PostDetailsPresenter;
import com.matuszew.braintri_tumblr.posts.list.PostsListContract;
import com.matuszew.braintri_tumblr.posts.list.PostsListPresenter;
import com.matuszew.braintri_tumblr.splash.SplashContract;
import com.matuszew.braintri_tumblr.splash.SplashPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by matuszewski on 24/04/2017.
 */

@Module
public abstract class PresenterModule {

    @Binds
    abstract SplashContract.Presenter providesSplashPresenter(SplashPresenter splashPresenter);

    @Binds
    abstract LoginContract.Presenter providesLoginPresenter(LoginPresenter loginPresenter);

    @Binds
    abstract PostsListContract.Presenter providesPostsListPresenter(PostsListPresenter listPresenter);

    @Binds
    abstract PostDetailsContract.Presenter providesPostDetailsPresenter(PostDetailsPresenter detailsPresenter);

}
