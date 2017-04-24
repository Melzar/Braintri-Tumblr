package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.di.module.PresenterModule;
import com.matuszew.braintri_tumblr.common.di.module.ViewModelModule;
import com.matuszew.braintri_tumblr.common.di.scope.ActivityScope;
import com.matuszew.braintri_tumblr.login.LoginActivity;

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

        void inject(LoginActivity loginActivity);

        HelperSubComponent plus();
}
