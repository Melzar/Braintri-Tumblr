package com.matuszew.data.common.model.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class TumblrJson {

    private TumbleLogJson tumblelog;
    @SerializedName("posts-start")
    private Long postsStart;
    @SerializedName("posts-total")
    private Long postsTotal;

    private List<PostJson> posts;

    public TumblrJson() {
    }

    public TumblrJson(TumbleLogJson tumblelog,
                      Long postsStart,
                      Long postsTotal,
                      List<PostJson> posts) {
        this.tumblelog = tumblelog;
        this.postsStart = postsStart;
        this.postsTotal = postsTotal;
        this.posts = posts;
    }

    public TumbleLogJson getTumblelog() {
        return tumblelog;
    }

    public void setTumblelog(TumbleLogJson tumblelog) {
        this.tumblelog = tumblelog;
    }

    public Long getPostsStart() {
        return postsStart;
    }

    public void setPostsStart(Long postsStart) {
        this.postsStart = postsStart;
    }

    public Long getPostsTotal() {
        return postsTotal;
    }

    public void setPostsTotal(Long postsTotal) {
        this.postsTotal = postsTotal;
    }

    public List<PostJson> getPosts() {
        return posts;
    }

    public void setPosts(List<PostJson> posts) {
        this.posts = posts;
    }
}
