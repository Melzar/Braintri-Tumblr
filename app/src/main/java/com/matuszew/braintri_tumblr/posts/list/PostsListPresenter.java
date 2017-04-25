package com.matuszew.braintri_tumblr.posts.list;

import com.matuszew.braintri_tumblr.BasePresenter;

import javax.inject.Inject;

/**
 * Created by matuszewski on 25/04/2017.
 */

public class PostsListPresenter
        extends BasePresenter<PostsListContract.ViewModel> implements PostsListContract.Presenter {

    @Inject
    public PostsListPresenter(PostsListContract.ViewModel viewModel) {
        super(viewModel);
    }

    @Override
    public void init() {

    }

    @Override
    public void init(Object model) {

    }

    @Override
    public void clear() {

    }
}
