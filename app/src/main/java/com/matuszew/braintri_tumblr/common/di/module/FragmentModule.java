package com.matuszew.braintri_tumblr.common.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.matuszew.braintri_tumblr.common.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matuszewski on 30/04/2017.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    public Fragment providesFragment(){ return fragment; }

    @FragmentScope
    @Provides
    public FragmentManager providesFragmentManager(){ return fragment.getFragmentManager();}
}
