package com.matuszew.braintri_tumblr.common.enumeration;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.typedef.PostType;

import java.util.HashMap;

/**
 * Created by matuszewski on 29/04/2017.
 */

public enum PostBackgroundEnumeration {

    REGULAR(R.color.colorBlacky),
    LINK(R.color.colorGreen),
    AUDIO(R.color.colorViolet),
    CONVERSATION(R.color.colorBlue),
    PHOTO(R.color.colorLightRed),
    QUOTE(R.color.colorOrange),
    VIDEO(R.color.colorMediumGray);

    private int postBackgroundColor;

    private static HashMap<String,PostBackgroundEnumeration> backgroundMapping = new HashMap<String, PostBackgroundEnumeration>(){{
        put(PostType.REGULAR, REGULAR);
        put(PostType.LINK, LINK);
        put(PostType.AUDIO, AUDIO);
        put(PostType.CONVERSATION, CONVERSATION);
        put(PostType.PHOTO, PHOTO);
        put(PostType.QUOTE, QUOTE);
        put(PostType.VIDEO, VIDEO);
    }};

    PostBackgroundEnumeration(int postHeaderColor) {
        this.postBackgroundColor = postHeaderColor;
    }

    public static PostBackgroundEnumeration getPostBackgroundFromString(String postType){
        if(backgroundMapping.containsKey(postType)){
            return backgroundMapping.get(postType);
        }
        return REGULAR;
    }

    public int getPostBackgroundColor() {
        return postBackgroundColor;
    }
}
