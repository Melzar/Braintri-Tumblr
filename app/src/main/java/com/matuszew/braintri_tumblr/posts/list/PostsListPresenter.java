package com.matuszew.braintri_tumblr.posts.list;

import com.matuszew.braintri_tumblr.BasePresenter;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.domain.posts.list.GetPostsUseCase;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by matuszewski on 25/04/2017.
 */

public class PostsListPresenter
        extends BasePresenter<PostsListContract.ViewModel> implements PostsListContract.Presenter {

    private final GetPostsUseCase getPostsUseCase;

    private final SingleObserver<Tumblr> singleObserver = new SingleObserver<Tumblr>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onError(@NonNull Throwable e) {
            //TODO Add error notificator
        }

        @Override
        public void onSuccess(@NonNull Tumblr tumblr) {
            getViewModel().update(tumblr);
        }
    };

    @Inject
    public PostsListPresenter(PostsListContract.ViewModel viewModel,
                              GetPostsUseCase getPostsUseCase) {
        super(viewModel);
        this.getPostsUseCase = getPostsUseCase;
    }

    @Override
    public void init() {
        getPostsUseCase.execute(singleObserver, null);
    }

    @Override
    public void init(Tumblr model) {

    }

    @Override
    public void clear() {

    }
}
