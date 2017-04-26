package com.matuszew.braintri_tumblr.posts.list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.matuszew.braintri_tumblr.BaseDrawerActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.databinding.ActivityPostsListBinding;

public class PostsListActivity
        extends BaseDrawerActivity<ActivityPostsListBinding, PostsListContract.Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityLayout() {
        setActivityLayoutAndBinding(R.layout.activity_posts_list);
        binding.postListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void injectDependencies(ActivitySubComponent activitySubComponent) {
       activitySubComponent.inject(this);
    }
}
