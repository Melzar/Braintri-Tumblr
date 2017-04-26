package com.matuszew.braintri_tumblr.posts.details;

import com.matuszew.braintri_tumblr.BasePresenter;
import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.domain.posts.details.GetPostDetailsUseCase;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsPresenter
        extends BasePresenter<PostDetailsContract.ViewModel> implements PostDetailsContract.Presenter {

    private final GetPostDetailsUseCase getPostDetailsUseCase;

    private final SingleObserver<Tumblr> singleObserver = new SingleObserver<Tumblr>() {

        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onSuccess(@NonNull Tumblr o) {

        }
    };

    @Inject
    public PostDetailsPresenter(PostDetailsContract.ViewModel viewModel,
                                GetPostDetailsUseCase getPostDetailsUseCase) {
        super(viewModel);
        this.getPostDetailsUseCase = getPostDetailsUseCase;
    }

    @Override
    public void init() {
    }

    @Override
    public void init(Post model) {
        getPostDetailsUseCase.execute(singleObserver, new GetPostDetailsRequest(model.getId()));
    }

    @Override
    public void clear() {

    }
}
