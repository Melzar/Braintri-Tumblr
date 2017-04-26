package com.matuszew.data.posts;

import com.matuszew.data.common.model.bo.Tumblr;
import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.data.posts.request.GetPostsRequest;

import io.reactivex.Single;

/**
 * Created by matuszewski on 26/04/2017.
 */

public interface PostsRepository {

    Single<Tumblr> getPostsList(GetPostsRequest getPostsRequest);

    Single<Tumblr> getPostDetails(GetPostDetailsRequest getPostDetailsRequest);
}
