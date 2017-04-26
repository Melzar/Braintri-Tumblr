package com.matuszew.braintri_tumblr.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class SessionUtil {

    public static void addItemToSession(int sessionKey, String item){
        getPreferences()
                .edit()
                .putString(BraintriTumblrApplication.getApplication().getString(sessionKey), item)
                .apply();
    }

    public static void clearSession(){
        getPreferences()
                .edit()
                .clear()
                .apply();
    }

    public static String getSessionValue(int stringKey){
        return getPreferences()
                .getString(BraintriTumblrApplication.getApplication().getString(stringKey), null);
    }

    private static SharedPreferences getPreferences(){
        return BraintriTumblrApplication.getApplication().getSharedPreferences(
                BraintriTumblrApplication.getApplication().getString(R.string.braintri_session),
                Context.MODE_PRIVATE);
    }
}
