package com.matuszew.data.posts.request;

/**
 * Created by matuszewski on 26/04/2017.
 */

/**
 *
 The most recent 20 posts are included by default. You may pass these optional GET parameters:

 start - The post offset to start from. The default is 0.

 num - The number of posts to return. The default is 20, and the maximum is 50.

 type - The type of posts to return. If unspecified or empty, all types of posts are returned.
 Must be one of text, quote, photo, link, chat, video, or audio.

 id - A specific post ID to return. Use instead of start, num, or type.

 filter - Alternate filter to run on the text content. Allowed values:

 text - Plain text only. No HTML.
 none - No post-processing. Output exactly what the author entered.
 (Note: Some authors write in Markdown, which will not be converted to HTML when this option is used.)
 tagged - Return posts with this tag in reverse-chronological order (newest first).

 Optionally specify chrono=1 to sort in chronological order (oldest first).
 *
 */

public class GetPostsRequest {

    private String start;
    private String num;
    private String type;
    private String filter;
    private String tagged;
    private String chrono;

    public GetPostsRequest(String start,
                           String num,
                           String type,
                           String filter,
                           String tagged,
                           String chrono) {
        this.start = start;
        this.num = num;
        this.type = type;
        this.filter = filter;
        this.tagged = tagged;
        this.chrono = chrono;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getTagged() {
        return tagged;
    }

    public void setTagged(String tagged) {
        this.tagged = tagged;
    }

    public String getChrono() {
        return chrono;
    }

    public void setChrono(String chrono) {
        this.chrono = chrono;
    }
}
