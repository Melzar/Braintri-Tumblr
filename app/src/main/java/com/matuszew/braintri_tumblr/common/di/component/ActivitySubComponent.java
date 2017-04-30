package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.di.module.FragmentModule;
import com.matuszew.braintri_tumblr.common.di.module.PresenterModule;
import com.matuszew.braintri_tumblr.common.di.module.ViewModelModule;
import com.matuszew.braintri_tumblr.common.di.scope.ActivityScope;
import com.matuszew.braintri_tumblr.login.LoginActivity;
import com.matuszew.braintri_tumblr.posts.details.PostDetailsActivity;
import com.matuszew.braintri_tumblr.posts.list.PostsListActivity;
import com.matuszew.braintri_tumblr.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by matuszewski on 24/04/2017.
 */

@ActivityScope
@Subcomponent(modules = {
        ActivityModule.class,
        PresenterModule.class,
        ViewModelModule.class
})
public interface ActivitySubComponent {

        void inject(SplashActivity splashActivity);
        void inject(LoginActivity loginActivity);
        void inject(PostsListActivity postsListActivity);
        void inject(PostDetailsActivity postDetailsActivity);

        HelperSubComponent plus();
        ViewHolderSubComponent plusViewHolder();
        FragmentSubComponent plusFragment(FragmentModule fragmentModule);
}
