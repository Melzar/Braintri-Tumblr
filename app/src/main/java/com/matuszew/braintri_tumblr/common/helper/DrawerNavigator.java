package com.matuszew.braintri_tumblr.common.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.matuszew.braintri_tumblr.BaseDrawerActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.enumeration.DrawerMenuEnumeration;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matuszewski on 25/04/2017.
 */

public final class DrawerNavigator extends ContextWrapper
        implements NavigationView.OnNavigationItemSelectedListener {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.drawer_navigation_view)
    NavigationView navigationView;

    @Inject
    Navigator navigator;

    @Inject
    public DrawerNavigator(Context base) {
        super(base);
        setupActionBar();
    }

    private void setupActionBar(){
        BaseDrawerActivity baseDrawerActivity = ((BaseDrawerActivity)getBaseContext());
        ButterKnife.bind(this, baseDrawerActivity);
        baseDrawerActivity.setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(baseDrawerActivity,
                drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        baseDrawerActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        baseDrawerActivity.getSupportActionBar().setHomeButtonEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigator.startActivityTop(DrawerMenuEnumeration.values()[item.getOrder()].getActivityClass());
        hideDrawer();
        return true;
    }

    public void hideDrawer(){
        if(isOpen()){
            drawer.closeDrawer(Gravity.START);
        }
    }

    public boolean isOpen(){
        return drawer.isDrawerOpen(Gravity.START);
    }
}
