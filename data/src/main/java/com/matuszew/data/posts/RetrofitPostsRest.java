package com.matuszew.data.posts;

import com.matuszew.data.common.model.json.TumblrJson;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by matuszewski on 26/04/2017.
 */

public interface RetrofitPostsRest {

    @GET("json")
    Single<TumblrJson> getPosts();

    @GET("json")
    Single<TumblrJson> getPost(@Query("id") String postId);

}
