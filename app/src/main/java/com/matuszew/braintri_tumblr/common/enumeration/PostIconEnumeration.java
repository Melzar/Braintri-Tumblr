package com.matuszew.braintri_tumblr.common.enumeration;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.typedef.PostType;

import java.util.HashMap;

/**
 * Created by matuszewski on 29/04/2017.
 */

public enum  PostIconEnumeration {

    REGULAR(R.drawable.format_text),
    LINK(R.drawable.link_variant),
    AUDIO(R.drawable.headphones),
    CONVERSATION(R.drawable.comment_text_outline),
    PHOTO(R.drawable.camera),
    QUOTE(R.drawable.format_quote_close);

    private int postIcon;

    private static HashMap<String, PostIconEnumeration> iconMapping =
            new HashMap<String, PostIconEnumeration>(){{
        put(PostType.REGULAR, REGULAR);
        put(PostType.LINK, LINK);
        put(PostType.AUDIO, AUDIO);
        put(PostType.CONVERSATION, CONVERSATION);
        put(PostType.PHOTO, PHOTO);
        put(PostType.QUOTE, QUOTE);
    }};

    PostIconEnumeration(int postIcon){
        this.postIcon = postIcon;
    }

    public static PostIconEnumeration getPostIconFromString(String postType){
        if(iconMapping.containsKey(postType)){
            return iconMapping.get(postType);
        }
        return REGULAR;
    }

    public int getPostIcon() {
        return postIcon;
    }
}