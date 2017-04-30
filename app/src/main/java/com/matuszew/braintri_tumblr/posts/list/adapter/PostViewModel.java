package com.matuszew.braintri_tumblr.posts.list.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.enumeration.PostBackgroundEnumeration;
import com.matuszew.braintri_tumblr.common.enumeration.PostIconEnumeration;
import com.matuszew.braintri_tumblr.common.formatter.DateFormatter;
import com.matuszew.braintri_tumblr.posts.details.PostDetailsActivity;
import com.matuszew.data.common.model.bo.Post;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class PostViewModel
        extends BaseViewModel<Post, Void>
        implements PostViewContract.ViewModel {

    @Inject
    public PostViewModel() {
    }

    @Override
    protected void init() {

    }

    public void itemClicked(){
        Bundle bundle = new Bundle();
        bundle.putParcelable(BraintriTumblrApplication.getApplication()
                .getString(R.string.post_parcel_key), Parcels.wrap(getModel()));
        navigator.startActivity(PostDetailsActivity.class, bundle);
    }

    @Override
    public String getDate() {
        return DateFormatter.formatDateFromString(BraintriTumblrApplication.getApplication()
                .getString(R.string.tumblr_source_date_format),BraintriTumblrApplication.getApplication()
                .getString(R.string.default_date_format),getModel().getDate());
    }

    @Override
    public String getNotes() {
        return BraintriTumblrApplication.getApplication()
                .getString(R.string.post_item_notes, getModel().getNoteCount());
    }

    @Override
    public Drawable getIcon() {
        return BraintriTumblrApplication.getApplication()
                .getResources().getDrawable(PostIconEnumeration.getPostIconFromString(getModel()
                        .getType()).getPostIcon());
    }

    @Override
    public int getHeaderBackground() {
        return BraintriTumblrApplication
                .getApplication().getResources().getColor(PostBackgroundEnumeration.getPostBackgroundFromString(getModel()
                        .getType()).getPostBackgroundColor());
    }

    @BindingAdapter("postTags")
    public static void applyPostTags(FlexboxLayout linearLayout, List<String> tagList){
        if(tagList != null && linearLayout.getChildCount() == 0){
            for (String tag: tagList) {
                TextView textView = new TextView(linearLayout.getContext());
                textView.setTextColor(BraintriTumblrApplication.getApplication()
                        .getResources().getColor(R.color.colorLightGray));
                textView.setText(BraintriTumblrApplication
                        .getApplication().getString(R.string.post_item_tag, tag));
                linearLayout.addView(textView);
            }
        }
    }
}
