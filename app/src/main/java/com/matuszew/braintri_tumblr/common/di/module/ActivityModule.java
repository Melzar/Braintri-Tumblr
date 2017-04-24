package com.matuszew.braintri_tumblr.common.di.module;

import android.content.Context;

import com.matuszew.braintri_tumblr.common.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matuszewski on 24/04/2017.
 */

@Module
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @ActivityScope
    @Provides
    public Context providesContext(){ return context; }
}
