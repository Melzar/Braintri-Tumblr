package com.matuszew.braintri_tumblr.posts.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.posts.list.view_holder.TumblrPostViewHolder;
import com.matuszew.data.common.model.bo.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class TumblrPostsAdapter extends RecyclerView.Adapter<TumblrPostViewHolder> {

    private List<Post> postList = new ArrayList<>();

    @Inject
    public TumblrPostsAdapter() {
    }

    @Override
    public TumblrPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.partial_post_item, parent, false);
        return new TumblrPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TumblrPostViewHolder holder, int position) {
        holder.getViewModel().update(postList.get(position));
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
