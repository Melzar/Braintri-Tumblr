package com.matuszew.braintri_tumblr.posts.list.adapter;

import android.os.Bundle;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.BaseViewModelContract;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.posts.details.PostDetailsActivity;
import com.matuszew.braintri_tumblr.posts.list.PostsListContract;
import com.matuszew.data.common.model.bo.Post;

import org.parceler.Parcels;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class PostViewModel
        extends BaseViewModel<Post, PostsListContract.Presenter>
        implements BaseViewModelContract<Post, PostsListContract.Presenter> {

    @Inject
    public PostViewModel() {
    }

    @Override
    protected void init() {

    }

    public void itemClicked(){
        Bundle bundle = new Bundle();
        bundle.putParcelable(BraintriTumblrApplication.getApplication()
                .getString(R.string.post_parcel_key), Parcels.wrap(getModel()));
        navigator.startActivity(PostDetailsActivity.class, bundle);
    }

}
