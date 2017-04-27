package com.matuszew.braintri_tumblr.common.di.container;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.matuszew.braintri_tumblr.common.di.component.ApplicationComponent;
import com.matuszew.braintri_tumblr.common.di.component.DaggerApplicationComponent;
import com.squareup.leakcanary.LeakCanary;

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
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        Stetho.initializeWithDefaults(this);

    }

    public static BraintriTumblrApplication getApplication() {
        return application;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
