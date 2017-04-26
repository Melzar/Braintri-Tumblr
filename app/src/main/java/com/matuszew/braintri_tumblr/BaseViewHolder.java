package com.matuszew.braintri_tumblr;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.matuszew.braintri_tumblr.common.di.component.ViewHolderSubComponent;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public abstract class BaseViewHolder<VM extends BaseViewModelContract> extends RecyclerView.ViewHolder{

    protected ViewDataBinding binding;

    @Inject
    VM viewModel;

    public BaseViewHolder(View itemView) {
        super(itemView);
        injectDependencies(BraintriTumblrApplication
                .getApplication()
                .getApplicationComponent()
                .plus(new ActivityModule(itemView.getContext()))
                .plusViewHolder());
        binding = DataBindingUtil.bind(itemView);
        binding.setVariable(BR.vm, viewModel);
    }

    public void bind() { binding.executePendingBindings(); }

    public VM getViewModel() {
        return viewModel;
    }

    protected abstract void injectDependencies(ViewHolderSubComponent viewHolderSubComponent);
}
