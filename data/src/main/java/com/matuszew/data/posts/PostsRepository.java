package com.matuszew.data.posts;

import com.matuszew.data.posts.request.GetPostDetailsRequest;
import com.matuszew.data.posts.request.GetPostsRequest;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by matuszewski on 26/04/2017.
 */

public interface PostsRepository {

    Single<List<Object>> getPostsList(GetPostsRequest getPostsRequest);

    Single<Object> getPostDetails(GetPostDetailsRequest getPostDetailsRequest);
}
