package com.matuszew.braintri_tumblr.common.di.component;

import com.matuszew.braintri_tumblr.common.di.scope.ViewHolderScope;
import com.matuszew.braintri_tumblr.posts.list.view_holder.TumblrPostViewHolder;

import dagger.Subcomponent;

/**
 * Created by matuszewski on 27/04/2017.
 */

@ViewHolderScope
@Subcomponent
public interface ViewHolderSubComponent {

    void inject(TumblrPostViewHolder tumblrPostViewHolder);
}
