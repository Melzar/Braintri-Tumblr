package com.matuszew.data.posts;

import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.data.posts.request.GetPostsRequest;

import java.util.List;

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
    public Single<List<Object>> getPostsList(GetPostsRequest getPostsRequest) {
        return postsRest.getPosts().flatMap(new Function<List<Object>, SingleSource<? extends List<Object>>>() {
            @Override
            public SingleSource<? extends List<Object>> apply(@NonNull List<Object> objects) throws Exception {
                return null;
            }
        });
    }

    @Override
    public Single<Object> getPostDetails(GetPostDetailsRequest getPostDetailsRequest) {
        return postsRest.getPost().flatMap(new Function<Object, SingleSource<? extends Object>>() {
            @Override
            public SingleSource<? extends Object> apply(@NonNull Object objects) throws Exception {
                return null;
            }
        });
    }
}
