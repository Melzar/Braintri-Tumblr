package com.matuszew.braintri_tumblr.posts.details;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.enumeration.PostBackgroundEnumeration;
import com.matuszew.braintri_tumblr.common.enumeration.PostIconEnumeration;
import com.matuszew.braintri_tumblr.common.formatter.DateFormatter;
import com.matuszew.data.common.model.bo.Post;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostDetailsViewModel
        extends BaseViewModel<Post, PostDetailsContract.Presenter>
        implements PostDetailsContract.ViewModel {

    @Inject
    public PostDetailsViewModel(){
    }

    @Override
    protected void init() {

    }

    @BindingAdapter("htmlText")
    public static void preselectType(TextView textView, String text){
        if(text != null){
            textView.setText(Html.fromHtml(text));
        }
    }

    @BindingAdapter("imageFromUrl")
    public static void applyImage(ImageView imageView, String url){
        if(url != null){
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter("htmlContent")
    public static void applyWebContent(WebView webView, String content){
        if(content != null){
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadData(content,"text/html; charset=utf-8", "UTF-8");
        }
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
                .getApplication().getResources()
                .getColor(PostBackgroundEnumeration.getPostBackgroundFromString(getModel()
                        .getType()).getPostBackgroundColor());
    }
}
