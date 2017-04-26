package com.matuszew.data.posts.request;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class GetPostDetailsRequest {

    private String postId;

    public GetPostDetailsRequest(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
