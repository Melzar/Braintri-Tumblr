package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.module.FragmentModule;
import com.matuszew.braintri_tumblr.common.di.scope.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by matuszewski on 30/04/2017.
 */

@FragmentScope
@Subcomponent(modules = {
        FragmentModule.class
})
public interface FragmentSubComponent {
    
}
