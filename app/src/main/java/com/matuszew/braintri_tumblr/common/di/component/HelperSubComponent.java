package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.scope.HelperScope;
import com.matuszew.braintri_tumblr.common.helper.Layouter;

import dagger.Subcomponent;

/**
 * Created by matuszewski on 24/04/2017.
 */

@HelperScope
@Subcomponent
public interface HelperSubComponent {

    Layouter provideLayouter();
}
