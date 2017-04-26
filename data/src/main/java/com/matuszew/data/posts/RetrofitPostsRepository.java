package com.matuszew.data.posts;

import com.matuszew.data.common.mapper.tumblr.RestTumblrMapper;
import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.common.model.json.TumblrJson;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.data.posts.request.GetPostsRequest;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class RetrofitPostsRepository implements PostsRepository {

    private final RetrofitPostsRest postsRest;

    public RetrofitPostsRepository(RetrofitPostsRest postsRest) {
        this.postsRest = postsRest;
    }

    @Override
    public Single<Tumblr> getPostsList(GetPostsRequest getPostsRequest) {
        return postsRest.getPosts().flatMap(new Function<TumblrJson, SingleSource<? extends Tumblr>>() {
            @Override
            public SingleSource<? extends Tumblr> apply(@NonNull TumblrJson tumblrJson) throws Exception {
               return Single.just(RestTumblrMapper.INSTANCE.map(tumblrJson));
            }
        });
    }

    @Override
    public Single<Tumblr> getPostDetails(GetPostDetailsRequest getPostDetailsRequest) {
        return postsRest.getPost(getPostDetailsRequest.getPostId())
                .flatMap(new Function<TumblrJson, SingleSource<? extends Tumblr>>() {
            @Override
            public SingleSource<? extends Tumblr> apply(@NonNull TumblrJson tumblrJson) throws Exception {
                return Single.just(RestTumblrMapper.INSTANCE.map(tumblrJson));
            }
        });
    }
}
