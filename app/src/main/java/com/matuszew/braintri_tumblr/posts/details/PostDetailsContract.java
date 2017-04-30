package com.matuszew.braintri_tumblr.posts.details;

import android.graphics.drawable.Drawable;

import com.matuszew.braintri_tumblr.BasePresenterContract;
import com.matuszew.braintri_tumblr.BaseViewModelContract;
import com.matuszew.data.common.model.bo.Post;

/**
 * Created by matuszewski on 26/04/2017.
 */

public interface PostDetailsContract {

    interface Presenter extends BasePresenterContract<Post, ViewModel>{

    }

    interface ViewModel extends BaseViewModelContract<Post, Presenter>{

        public String getDate();
        public String getNotes();
        public Drawable getIcon();
        public int getHeaderBackground();
        public void navigateToUrl();

    }
}
