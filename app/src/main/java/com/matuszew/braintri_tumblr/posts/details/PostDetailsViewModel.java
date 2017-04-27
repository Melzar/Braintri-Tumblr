package com.matuszew.braintri_tumblr.posts.details;

import android.databinding.BindingAdapter;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.matuszew.braintri_tumblr.BaseViewModel;
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
}
