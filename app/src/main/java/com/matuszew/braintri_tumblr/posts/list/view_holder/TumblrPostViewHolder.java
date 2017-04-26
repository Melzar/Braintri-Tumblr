package com.matuszew.braintri_tumblr.posts.list.view_holder;

import android.view.View;

import com.matuszew.braintri_tumblr.BaseViewHolder;
import com.matuszew.braintri_tumblr.common.di.component.ViewHolderSubComponent;
import com.matuszew.braintri_tumblr.posts.list.adapter.PostViewModel;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class TumblrPostViewHolder extends BaseViewHolder<PostViewModel> {

    public TumblrPostViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void injectDependencies(ViewHolderSubComponent viewHolderSubComponent) {
        viewHolderSubComponent.inject(this);
    }
}
