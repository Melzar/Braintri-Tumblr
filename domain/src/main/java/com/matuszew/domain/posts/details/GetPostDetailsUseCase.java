package com.matuszew.domain.posts.details;

import com.matuszew.data.common.model.bo.Post;
import com.matuszew.data.posts.PostsRepository;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.domain.common.usecase.SingleUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class GetPostDetailsUseCase extends SingleUseCase<Post, GetPostDetailsRequest> {

    private final PostsRepository postsRepository;

    @Inject
    public GetPostDetailsUseCase(@Named("subscribe") Scheduler subscribeScheduler,
                                 @Named("observe") Scheduler observingScheduler,
                                 @Named("remote") PostsRepository postsRepository) {
        super(subscribeScheduler, observingScheduler);
        this.postsRepository = postsRepository;
    }

    @Override
    protected Single<Post> createObservable(GetPostDetailsRequest request) {
        return postsRepository.getPostDetails(request);
    }
}
