package com.matuszew.braintri_tumblr;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matuszew.braintri_tumblr.common.di.component.FragmentSubComponent;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;
import com.matuszew.braintri_tumblr.common.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by matuszewski on 30/04/2017.
 */

public abstract class BaseFragment<B extends ViewDataBinding, P extends BasePresenterContract>
        extends Fragment {

    protected B binding;
    @Inject
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(BraintriTumblrApplication.getApplication().getApplicationComponent()
                .plus(new ActivityModule(getActivity())).plusFragment(new FragmentModule(this)));
    }

    protected View setFragmentBinding(LayoutInflater inflater,
                                      @Nullable ViewGroup container,
                                      @Nullable Bundle savedInstance,
                                      @LayoutRes int layoutResource){
        binding = DataBindingUtil.inflate(inflater,layoutResource,container,false);
        binding.setVariable(BR.vm, presenter.getViewModel());
        initalize();
        return binding.getRoot();
    }

    protected abstract void initalize();

    protected abstract void injectDependencies(FragmentSubComponent fragmentSubComponent);
}
