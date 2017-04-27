package com.matuszew.braintri_tumblr.posts.details.enumeration;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.AUDIO;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.CONVERSATION;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.LINK;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.PHOTO;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.QUOTE;
import static com.matuszew.braintri_tumblr.posts.details.enumeration.PostType.REGULAR;

/**
 * Created by matuszewski on 27/04/2017.
 */
@StringDef({REGULAR, LINK, AUDIO, CONVERSATION, PHOTO, QUOTE})
@Retention(RetentionPolicy.SOURCE)
public @interface PostType {
    String REGULAR = "regular";
    String LINK = "link";
    String AUDIO = "audio";
    String CONVERSATION = "conversation";
    String PHOTO = "photo";
    String QUOTE = "quote";
}

