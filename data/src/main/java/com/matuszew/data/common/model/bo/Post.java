package com.matuszew.data.common.model.bo;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Parcel(Parcel.Serialization.FIELD)
public class Post {

    private String id;
    private String url;
    private String urlWithSlug;
    private String type;
    private String dateGmt;
    private String date;

    public Post() {
    }

    @ParcelConstructor
    public Post(String id,
                String url,
                String urlWithSlug,
                String type,
                String dateGmt,
                String date) {
        this.id = id;
        this.url = url;
        this.urlWithSlug = urlWithSlug;
        this.type = type;
        this.dateGmt = dateGmt;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlWithSlug() {
        return urlWithSlug;
    }

    public void setUrlWithSlug(String urlWithSlug) {
        this.urlWithSlug = urlWithSlug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateGmt() {
        return dateGmt;
    }

    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
