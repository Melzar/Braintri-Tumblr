package com.matuszew.braintri_tumblr.posts.list.adapter;

import com.matuszew.braintri_tumblr.BaseViewModelContract;
import com.matuszew.data.common.model.bo.Post;

/**
 * Created by matuszewski on 29/04/2017.
 */

public interface PostViewContract {

    interface ViewModel extends BaseViewModelContract<Post, Void>{

        public String getDate();
        public String getNotes();
        public int getIcon();
        public int getHeaderBackground();

    }
}
