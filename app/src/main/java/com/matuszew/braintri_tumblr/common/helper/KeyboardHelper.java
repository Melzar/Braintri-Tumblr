package com.matuszew.braintri_tumblr.common.helper;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.matuszew.braintri_tumblr.BaseActivity;
import com.matuszew.braintri_tumblr.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnTouch;

/**
 * Created by matuszewski on 25/04/2017.
 */

public final class KeyboardHelper extends ContextWrapper {

    @Inject
    public KeyboardHelper(Context base) {
        super(base);
        ButterKnife.bind(this, (BaseActivity) base);
    }

    @OnTouch(R.id.screen_root_view)
    public boolean hideKeyboard(){
        hideSoftKeyboard();
        return false;
    }

    private void hideSoftKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getBaseContext()
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        BaseActivity baseActivity = (BaseActivity)getBaseContext();
        View focusedView = baseActivity.getCurrentFocus();
        if (focusedView != null){
            inputMethodManager
                    .hideSoftInputFromWindow(focusedView.getWindowToken(),
                            InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

}
