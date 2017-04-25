package com.matuszew.braintri_tumblr.posts.details;

import com.matuszew.braintri_tumblr.BasePresenter;

import javax.inject.Inject;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsPresenter
        extends BasePresenter<PostDetailsContract.ViewModel> implements PostDetailsContract.Presenter {

    @Inject
    public PostDetailsPresenter(PostDetailsContract.ViewModel viewModel) {
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
