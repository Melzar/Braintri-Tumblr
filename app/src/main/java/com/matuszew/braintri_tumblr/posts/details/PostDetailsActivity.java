package com.matuszew.braintri_tumblr.posts.details;

import android.os.Bundle;

import com.matuszew.braintri_tumblr.BaseDrawerActivity;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.databinding.ActivityPostDetailsBinding;

public class PostDetailsActivity
        extends BaseDrawerActivity<ActivityPostDetailsBinding, PostDetailsContract.Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityLayout() {
        setActivityLayoutAndBinding(R.layout.activity_post_details);
    }

    @Override
    protected void injectDependencies(ActivitySubComponent activitySubComponent) {
        activitySubComponent.inject(this);
    }
}
