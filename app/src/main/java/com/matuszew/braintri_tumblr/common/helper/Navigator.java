package com.matuszew.braintri_tumblr.common.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

import javax.inject.Inject;

/**
 * Created by matuszewski on 25/04/2017.
 */

public final class Navigator extends ContextWrapper{

    @Inject
    public Navigator(Context base) {
        super(base);
    }

    public void startActivity(Class activityToStart){
        startActivity(new Intent(getBaseContext(), activityToStart));
    }

    public void startActivityTop(Class activityToStart){
        Intent intent = new Intent(getBaseContext(), activityToStart);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
