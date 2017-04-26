package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.di.module.NetworkModule;
import com.matuszew.braintri_tumblr.common.di.module.RepositoryModule;
import com.matuszew.braintri_tumblr.common.di.module.ThreadModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by matuszewski on 24/04/2017.
 */

@Singleton
@Component(modules = {
        NetworkModule.class,
        ThreadModule.class,
        RepositoryModule.class
})
public interface ApplicationComponent {

    ActivitySubComponent plus(ActivityModule activityModule);

}
