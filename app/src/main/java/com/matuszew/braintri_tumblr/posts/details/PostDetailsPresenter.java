package com.matuszew.braintri_tumblr.posts.details;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewStub;

import com.matuszew.braintri_tumblr.BR;
import com.matuszew.braintri_tumblr.BasePresenter;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.enumeration.PostTypeEnumeration;
import com.matuszew.data.common.model.bo.Post;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsPresenter
        extends BasePresenter<PostDetailsContract.ViewModel> implements PostDetailsContract.Presenter {

    @BindView(R.id.post_details_stub)
    ViewStub stub;

    @Inject
    public PostDetailsPresenter(Context context,
                                PostDetailsContract.ViewModel viewModel) {
        super(viewModel);
        ButterKnife.bind(this, (PostDetailsActivity)context);
    }

    @Override
    public void init() {
    }

    @Override
    public void init(Post post) {
        stub.setLayoutResource(PostTypeEnumeration.getPostTypeEnumerationFromString(post.getType())
                .getLayoutRes());
        ViewDataBinding binding = DataBindingUtil.bind(stub.inflate());
        binding.setVariable(BR.vm, getViewModel());
        getViewModel().update(post);
    }

    @Override
    public void clear() {

    }
}
