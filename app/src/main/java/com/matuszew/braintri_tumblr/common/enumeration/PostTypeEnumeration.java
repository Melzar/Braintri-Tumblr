package com.matuszew.braintri_tumblr.common.enumeration;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.typedef.PostType;

import java.util.HashMap;

/**
 * Created by matuszewski on 30/04/2017.
 */

public enum  PostTypeEnumeration {

    REGULAR(R.layout.partial_post_details_regular),
    LINK(R.layout.partial_post_details_link),
    AUDIO(R.layout.partial_post_details_audio),
    CONVERSATION(R.layout.partial_post_details_conversation),
    PHOTO(R.layout.partial_post_details_photo),
    QUOTE(R.layout.partial_post_details_quote);

    private int layoutRes;

    private static HashMap<String, PostTypeEnumeration> map =
            new HashMap<String, PostTypeEnumeration>(){{
        put(PostType.REGULAR, REGULAR);
        put(PostType.LINK, LINK);
        put(PostType.AUDIO, AUDIO);
        put(PostType.CONVERSATION, CONVERSATION);
        put(PostType.PHOTO, PHOTO);
        put(PostType.QUOTE, QUOTE);
    }};

    PostTypeEnumeration(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public static PostTypeEnumeration getPostTypeEnumerationFromString(String postType){
        if(map.containsKey(postType)){
            return map.get(postType);
        }
        return REGULAR;
    }
}
