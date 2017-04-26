package com.matuszew.braintri_tumblr.posts.details;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.data.common.model.bo.Post;

import javax.inject.Inject;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsViewModel
        extends BaseViewModel<Post, PostDetailsContract.Presenter>
        implements PostDetailsContract.ViewModel {

    @Inject
    public PostDetailsViewModel() {
    }

    @Override
    protected void init() {

    }


}
