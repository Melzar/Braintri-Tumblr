package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.di.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by matuszewski on 24/04/2017.
 */

@ActivityScope
@Subcomponent(modules = {
        ActivityModule.class
})
public interface ActivitySubComponent {

}
