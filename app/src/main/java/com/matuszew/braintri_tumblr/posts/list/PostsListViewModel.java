package com.matuszew.braintri_tumblr.posts.list;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.posts.list.adapter.TumblrPostsAdapter;
import com.matuszew.data.common.model.bo.Tumblr;

import javax.inject.Inject;

/**
 * Created by matuszewski on 25/04/2017.
 */

public class PostsListViewModel
        extends BaseViewModel<Tumblr, PostsListContract.Presenter>
        implements PostsListContract.ViewModel {

    private final TumblrPostsAdapter postsAdapter;

    @Inject
    public PostsListViewModel(TumblrPostsAdapter postsAdapter) {
        this.postsAdapter = postsAdapter;
    }

    @Override
    protected void init() {
        postsAdapter.setPostList(getModel().getPosts());
        postsAdapter.notifyDataSetChanged();
    }

    public TumblrPostsAdapter getPostsAdapter() {
        return postsAdapter;
    }
}
