package com.matuszew.braintri_tumblr.posts.list.adapter;

import android.graphics.drawable.Drawable;

import com.matuszew.braintri_tumblr.BaseViewModelContract;
import com.matuszew.data.common.model.bo.Post;

/**
 * Created by matuszewski on 29/04/2017.
 */

public interface PostViewContract {

    interface ViewModel extends BaseViewModelContract<Post, Void>{

        public String getDate();
        public String getNotes();
        public Drawable getIcon();
        public int getHeaderBackground();

    }
}
