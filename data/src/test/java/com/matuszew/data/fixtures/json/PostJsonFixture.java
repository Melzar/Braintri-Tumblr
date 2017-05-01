package com.matuszew.data.fixtures.json;

import com.matuszew.data.common.model.json.ConversationJson;
import com.matuszew.data.common.model.json.PostJson;
import com.tobedevoured.modelcitizen.annotation.Blueprint;
import com.tobedevoured.modelcitizen.annotation.Default;
import com.tobedevoured.modelcitizen.annotation.MappedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matuszewski on 01/05/2017.
 */

@Blueprint(PostJson.class)
public class PostJsonFixture {

    @Default
    private String id = "123";
    @Default
    private String url = "http://www.example.com/";
    @Default
    private String urlWithSlug = "http://www.example.com/with-slug";
    @Default
    private String type = "regular";
    @Default
    private String dateGmt = "2017-04-28 22:22:54 GMT";
    @Default
    private String date = "Fri, 28 Apr 2017 18:22:54";
    @Default
    private String noteCount = "100";

    // QUOTE TYPE FIELDS
    @Default
    private String quoteText = "quote text";
    @Default
    private String quoteSource = "http://www.quotesource.com/";

    // PHOTO TYPE FIELDS
    @Default
    private String photoUrl1280 = "http://www.photourl.com/1280";
    @Default
    private String photoUrl500 = "http://www.photourl.com/500";
    @Default
    private String photoUrl400 = "http://www.photourl.com/400";
    @Default
    private String photoUrl250 = "http://www.photourl.com/250";
    @Default
    private String photoUrl100 = "http://www.photourl.com/100";
    @Default
    private String photoUrl75 = "http://www.photourl.com/75";

    // VIDEO TYPE FIELDS
    @Default
    private String videoCaption = "video caption";
    @Default
    private String videoSource = "http://www.videosource.com/";
    @Default
    private String videoPlayer = "http://www.videoplayer.com/";

    // CONVERSATION TYPE FIELDS
    @Default
    private String conversationTitle = "conversation title";
    @Default
    private String conversationText = "conversation text";

    @MappedList(target = ConversationJson.class, size = 3)
    List<ConversationJson> conversation;

    @Default
    List<String> tags = new ArrayList<String>() {{
        add("tag 1");
        add("tag 2");
        add("tag 3");
    }};

    // AUDIO TYPE FIELDS
    @Default
    private String id3Artist = "audio artist";
    @Default
    private String id3Album = "audio album";
    @Default
    private String id3Year = "audio year";
    @Default
    private String id3Track = "audio track";
    @Default
    private String id3Title = "audio title";
    @Default
    private String audioEmbed = "audio embeded";
    @Default
    private String audioPlayer = "audio player";

    //REGULAR TYPE FIELDS
    @Default
    private String regularTitle = "regular title";
    @Default
    private String regularBody = "regular body";

    //LINK TYPE FIELDS
    @Default
    private String linkText = "link text";
    @Default
    private String linkUrl = "http://www.linkurl.com/";
    @Default
    private String linkDescription = "link description";

}
