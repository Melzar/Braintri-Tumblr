package com.matuszew.braintri_tumblr.common.typedef;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.matuszew.braintri_tumblr.common.typedef.PostType.AUDIO;
import static com.matuszew.braintri_tumblr.common.typedef.PostType.CONVERSATION;
import static com.matuszew.braintri_tumblr.common.typedef.PostType.LINK;
import static com.matuszew.braintri_tumblr.common.typedef.PostType.PHOTO;
import static com.matuszew.braintri_tumblr.common.typedef.PostType.QUOTE;
import static com.matuszew.braintri_tumblr.common.typedef.PostType.REGULAR;

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

