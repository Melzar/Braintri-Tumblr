package com.matuszew.data.common.model.bo;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.List;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Parcel(Parcel.Serialization.FIELD)
public class Tumblr {

    private TumbleLog tumblelog;
    private Long postsStart;
    private Long postsTotal;

    private List<Post> posts;

    public Tumblr() {
    }

    @ParcelConstructor
    public Tumblr(TumbleLog tumblelog,
                  Long postsStart,
                  Long postsTotal,
                  List<Post> posts) {
        this.tumblelog = tumblelog;
        this.postsStart = postsStart;
        this.postsTotal = postsTotal;
        this.posts = posts;
    }

    public TumbleLog getTumblelog() {
        return tumblelog;
    }

    public void setTumblelog(TumbleLog tumblelog) {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
