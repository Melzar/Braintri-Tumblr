package com.matuszew.braintri_tumblr.posts.details;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewStub;

import com.matuszew.braintri_tumblr.BR;
import com.matuszew.braintri_tumblr.BasePresenter;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.domain.posts.details.GetPostDetailsUseCase;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.AUDIO;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.CONVERSATION;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.LINK;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.PHOTO;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.QUOTE;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.REGULAR;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsPresenter
        extends BasePresenter<PostDetailsContract.ViewModel> implements PostDetailsContract.Presenter {

    private final GetPostDetailsUseCase getPostDetailsUseCase;

    @BindView(R.id.post_details_stub)
    ViewStub stub;

    private final SingleObserver<Post> singleObserver = new SingleObserver<Post>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onSuccess(@NonNull Post post) {

            int layout;
            switch (post.getType()){
                case REGULAR : layout = R.layout.partial_post_details_regular ; break;
                case LINK : layout = R.layout.partial_post_details_link; break;
                case AUDIO : layout = R.layout.partial_post_details_audio ; break;
                case CONVERSATION : layout = R.layout.partial_post_details_conversation ; break;
                case PHOTO : layout = R.layout.partial_post_details_photo ; break;
                case QUOTE : layout = R.layout.partial_post_details_quote ; break;
                default: layout = R.layout.partial_post_details_regular ; break;

            }
            stub.setLayoutResource(layout);
            ViewDataBinding binding = DataBindingUtil.bind(stub.inflate());
            binding.setVariable(BR.vm, getViewModel());

            getViewModel().update(post);
        }
    };

    @Inject
    public PostDetailsPresenter(Context context,
                                PostDetailsContract.ViewModel viewModel,
                                GetPostDetailsUseCase getPostDetailsUseCase) {
        super(viewModel);
        this.getPostDetailsUseCase = getPostDetailsUseCase;
        ButterKnife.bind(this, (PostDetailsActivity)context);
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
