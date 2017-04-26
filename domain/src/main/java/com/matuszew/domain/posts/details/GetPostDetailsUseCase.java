package com.matuszew.domain.posts.details;

import com.matuszew.data.common.model.bo.Tumblr;
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

public class GetPostDetailsUseCase extends SingleUseCase<Tumblr, GetPostDetailsRequest> {

    private final PostsRepository postsRepository;

    @Inject
    public GetPostDetailsUseCase(@Named("subscribe") Scheduler subscribeScheduler,
                                 @Named("observe") Scheduler observingScheduler,
                                 @Named("remote") PostsRepository postsRepository) {
        super(subscribeScheduler, observingScheduler);
        this.postsRepository = postsRepository;
    }

    @Override
    protected Single<Tumblr> createObservable(GetPostDetailsRequest request) {
        return postsRepository.getPostDetails(request);
    }
}
