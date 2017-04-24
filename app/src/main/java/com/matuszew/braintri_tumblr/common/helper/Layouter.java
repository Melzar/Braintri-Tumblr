package com.matuszew.braintri_tumblr.common.helper;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;

import com.matuszew.braintri_tumblr.BaseActivity;
import com.matuszew.braintri_tumblr.R;

import butterknife.ButterKnife;

/**
 * Created by matuszewski on 24/04/2017.
 */

public class Layouter extends ContextWrapper {

    public Layouter(Context base) {
        super(base);
    }

    public View setActivityContentLayout(@LayoutRes int layoutId){
        ViewStub viewStub = ButterKnife.findById((BaseActivity)getBaseContext(), R.id.base_content);
        viewStub.setLayoutResource(layoutId);
        return viewStub.inflate();
    }
}
