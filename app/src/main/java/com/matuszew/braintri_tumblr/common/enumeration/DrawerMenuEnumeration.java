package com.matuszew.braintri_tumblr.common.enumeration;

import com.matuszew.braintri_tumblr.login.LoginActivity;
import com.matuszew.braintri_tumblr.posts.list.PostsListActivity;

/**
 * Created by matuszewski on 25/04/2017.
 */

public enum DrawerMenuEnumeration {

    POST_LIST(PostsListActivity.class),
    LOGOUT(LoginActivity.class);

    private Class activityClass;

    DrawerMenuEnumeration(Class activityClass) {
        this.activityClass = activityClass;
    }

    public Class getActivityClass() {
        return activityClass;
    }
}
