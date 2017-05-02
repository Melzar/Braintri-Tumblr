package com.matuszew.braintri_tumblr.posts.details;

import android.databinding.BindingAdapter;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.Gravity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matuszew.braintri_tumblr.BaseViewModel;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.enumeration.PostBackgroundEnumeration;
import com.matuszew.braintri_tumblr.common.enumeration.PostIconEnumeration;
import com.matuszew.braintri_tumblr.common.formatter.DateFormatter;
import com.matuszew.data.common.model.bo.Conversation;
import com.matuszew.data.common.model.bo.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

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
    public static void applyTextContent(TextView textView, String text){
        if(text != null){
            textView.setText(Html.fromHtml(text).toString());
        }
    }

    @BindingAdapter("htmlTextNonEscaped")
    public static void applyNonEscapedTextConent(TextView textView, String text){
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

    @BindingAdapter("conversation")
    public static void applyConversation(LinearLayout linearLayout,
                                         List<Conversation> conversationList){
        if(conversationList != null){
            String firstName = null;
            for (Conversation conversation: conversationList) {
                if(firstName == null){
                    firstName = conversation.getName();
                }
                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                CardView cardView = new CardView(linearLayout.getContext());
                TextView textView = new TextView(linearLayout.getContext());
                if(conversation.getName().equals(firstName)){
                    cardView.setBackground(BraintriTumblrApplication
                            .getApplication().getResources()
                            .getDrawable(R.drawable.drawable_rounded_blue));
                    textView.setTextColor(BraintriTumblrApplication
                            .getApplication().getResources()
                            .getColor(R.color.colorWhite));
                    params.gravity = Gravity.LEFT;
                }else{
                    params.gravity = Gravity.RIGHT;
                }
                params.setMargins(20, 20 , 20 , 20);
                cardView.setLayoutParams(params);
                cardView.setContentPadding(40, 40, 40 , 40);
                cardView.setCardElevation(10);
                textView.setText(BraintriTumblrApplication.getApplication()
                        .getString(R.string.post_conversation,
                                conversation.getLabel(), conversation.getPhrase()));
                cardView.addView(textView);
                linearLayout.addView(cardView);
            }
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
        return DateFormatter.
                formatDateFromString(BraintriTumblrApplication.getApplication()
                .getString(R.string.tumblr_source_date_format),BraintriTumblrApplication.getApplication()
                .getString(R.string.default_date_format),
                        getModel().getDate());
    }

    @Override
    public String getNotes() {
        return BraintriTumblrApplication.getApplication()
                .getString(R.string.post_item_notes, getModel().getNoteCount());
    }

    @Override
    public int getIcon() {
        return PostIconEnumeration.getPostIconFromString(getModel()
                .getType()).getPostIcon();
    }

    @Override
    public int getHeaderBackground() {
        return BraintriTumblrApplication
                .getApplication().getResources()
                .getColor(PostBackgroundEnumeration.getPostBackgroundFromString(getModel()
                        .getType()).getPostBackgroundColor());
    }

    @Override
    public void navigateToUrl() {
        navigator.navigateToUrl(getModel().getLinkUrl());
    }
}
