package com.matuszew.braintri_tumblr.common.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Module
public class ThreadModule {

    @Provides
    @Singleton
    @Named("subscribe")
    public Scheduler provideSubscribedOn(){return Schedulers.io();}

    @Provides
    @Singleton
    @Named("observe")
    public Scheduler provideObserveOn(){return AndroidSchedulers.mainThread();}
}
