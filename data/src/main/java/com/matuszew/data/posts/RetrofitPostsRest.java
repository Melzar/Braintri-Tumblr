package com.matuszew.data.posts;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by matuszewski on 26/04/2017.
 */

public interface RetrofitPostsRest {

    @GET
    Single<List<Object>> getPosts();

    @GET
    Single<Object> getPost();

}
