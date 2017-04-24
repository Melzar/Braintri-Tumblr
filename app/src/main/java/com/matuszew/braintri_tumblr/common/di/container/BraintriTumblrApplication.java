package com.matuszew.braintri_tumblr.common.di.container;

import android.app.Application;

import com.matuszew.braintri_tumblr.common.di.component.ApplicationComponent;
import com.matuszew.braintri_tumblr.common.di.component.DaggerApplicationComponent;

/**
 * Created by matuszewski on 24/04/2017.
 */

public class BraintriTumblrApplication extends Application {

    private ApplicationComponent applicationComponent;

    static BraintriTumblrApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        applicationComponent = DaggerApplicationComponent.builder().build();

    }

    public static BraintriTumblrApplication getApplication() {
        return application;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
