package com.matuszew.braintri_tumblr;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.matuszew.braintri_tumblr.common.di.component.ActivitySubComponent;
import com.matuszew.braintri_tumblr.common.di.component.ApplicationComponent;
import com.matuszew.braintri_tumblr.common.di.component.HelperSubComponent;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.helper.KeyboardHelper;
import com.matuszew.braintri_tumblr.common.helper.Layouter;

import javax.inject.Inject;

/**
 * Created by matuszewski on 24/04/2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding, P extends BasePresenterContract> extends AppCompatActivity {

    private Layouter layouter;

    @Inject
    KeyboardHelper keyboardHelper;

    @Inject
    protected P presenter;

    protected B binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent applicationComponent = BraintriTumblrApplication.getApplication()
                .getApplicationComponent();
        ActivityModule activityModule = new ActivityModule(this);

        HelperSubComponent helperSubComponent = applicationComponent.plus(activityModule).plus();

        layouter = helperSubComponent.provideLayouter();
        setLayout();
        setActivityLayout();
        injectDependencies(applicationComponent.plus(activityModule));
        setupBinding();

    }

    protected void setLayout(){
        setContentView(R.layout.base_content);
    }

    private void setupBinding(){
        binding.setVariable(BR.vm, presenter.getViewModel());
        presenter.init();
    }

    protected void setActivityLayoutAndBinding(@LayoutRes int layoutId){
        binding = DataBindingUtil.bind(layouter.setActivityContentLayout(layoutId));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void setActivityLayout();

    protected abstract void injectDependencies(ActivitySubComponent activitySubComponent);

}
