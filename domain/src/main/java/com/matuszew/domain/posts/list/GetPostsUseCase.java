package com.matuszew.domain.posts.list;

import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.posts.PostsRepository;
import com.matuszew.data.posts.request.GetPostsRequest;
import com.matuszew.domain.common.usecase.SingleUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class GetPostsUseCase extends SingleUseCase<Tumblr, GetPostsRequest> {

    private final PostsRepository postsRepository;

    @Inject
    public GetPostsUseCase(@Named("subscribe") Scheduler subscribeScheduler,
                           @Named("observe") Scheduler observingScheduler,
                           @Named("remote") PostsRepository postsRepository) {
        super(subscribeScheduler, observingScheduler);
        this.postsRepository = postsRepository;
    }

    @Override
    protected Single<Tumblr> createObservable(GetPostsRequest request) {
        return postsRepository.getPostsList(request);
    }
}
