package com.matuszew.braintri_tumblr.common.enumeration;

import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.posts.details.enumeration.PostType;

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
    MOVIE(R.color.colorMediumGray);

    private int postBackgroundColor;

    private static HashMap<String,PostBackgroundEnumeration> backgroundMapping = new HashMap<String, PostBackgroundEnumeration>(){{
        put(PostType.REGULAR, PostBackgroundEnumeration.REGULAR);
        put(PostType.LINK, PostBackgroundEnumeration.LINK);
        put(PostType.AUDIO, PostBackgroundEnumeration.AUDIO);
        put(PostType.CONVERSATION, PostBackgroundEnumeration.CONVERSATION);
        put(PostType.PHOTO, PostBackgroundEnumeration.PHOTO);
        put(PostType.QUOTE, PostBackgroundEnumeration.QUOTE);
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
