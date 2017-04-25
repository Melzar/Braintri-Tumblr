package com.matuszew.braintri_tumblr;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.matuszew.braintri_tumblr.common.helper.DrawerNavigator;

import javax.inject.Inject;

/**
 * Created by matuszewski on 25/04/2017.
 */

public abstract class BaseDrawerActivity<B extends ViewDataBinding, P extends BasePresenterContract>
        extends BaseActivity<B, P> {

    @Inject
    DrawerNavigator drawerNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setLayout() {
        super.setContentView(R.layout.base_drawer);
    }

    @Override
    public void onBackPressed() {
        if(drawerNavigator.isOpen()){
            drawerNavigator.hideDrawer();
        }else{
            super.onBackPressed();
        }
    }
}
