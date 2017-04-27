package com.matuszew.data.common.model.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by matuszewski on 26/04/2017.
 */

public class PostJson {

    private String id;
    private String url;
    @SerializedName("url-with-slug")
    private String urlWithSlug;
    private String type;
    @SerializedName("date-gmt")
    private String dateGmt;
    private String date;

    // QUOTE TYPE FIELD
    @SerializedName("quote-text")
    private String quoteText;
    @SerializedName("quote-source")
    private String quoteSource;

    // PHOTO TYPE FIELDS
    @SerializedName("photo-url-1280")
    private String photoUrl1280;
    @SerializedName("photo-url-500")
    private String photoUrl500;
    @SerializedName("photo-url-400")
    private String photoUrl400;
    @SerializedName("photo-url-250")
    private String photoUrl250;
    @SerializedName("photo-url-100")
    private String photoUrl100;
    @SerializedName("photo-url-75")
    private String photoUrl75;

    // CONVERSATION TYPE FIELDS
    @SerializedName("conversation-title")
    private String conversationTitle;
    @SerializedName("conversation-text")
    private String conversationText;
    List<ConversationJson> conversation;

    List<String> tags;

    // AUDIO TYPE FIELDS
    @SerializedName("id3-artist")
    private String id3Artist;
    @SerializedName("id3-album")
    private String id3Album;
    @SerializedName("id3-year")
    private String id3Year;
    @SerializedName("id3-track")
    private String id3Track;
    @SerializedName("id3-title")
    private String id3Title;
    @SerializedName("audio-embed")
    private String audioEmbed;
    @SerializedName("audio-player")
    private String audioPlayer;

    //REGULAR TYPE FIELDS
    @SerializedName("regular-title")
    private String regularTitle;
    @SerializedName("regular-body")
    private String regularBody;

    //LINK TYPE FIELDS
    @SerializedName("link-text")
    private String linkText;
    @SerializedName("link-url")
    private String linkUrl;
    @SerializedName("link-description")
    private String linkDescription;

    public PostJson() {
    }

    public PostJson(String id,
                    String url,
                    String urlWithSlug,
                    String type,
                    String dateGmt,
                    String date,
                    String quoteText,
                    String quoteSource,
                    String photoUrl1280,
                    String photoUrl500,
                    String photoUrl400,
                    String photoUrl250,
                    String photoUrl100,
                    String photoUrl75,
                    String conversationTitle,
                    String conversationText,
                    List<ConversationJson> conversation,
                    List<String> tags,
                    String id3Artist,
                    String id3Album,
                    String id3Year,
                    String id3Track,
                    String id3Title,
                    String audioEmbed,
                    String audioPlayer,
                    String regularTitle,
                    String regularBody,
                    String linkText,
                    String linkUrl,
                    String linkDescription) {
        this.id = id;
        this.url = url;
        this.urlWithSlug = urlWithSlug;
        this.type = type;
        this.dateGmt = dateGmt;
        this.date = date;
        this.quoteText = quoteText;
        this.quoteSource = quoteSource;
        this.photoUrl1280 = photoUrl1280;
        this.photoUrl500 = photoUrl500;
        this.photoUrl400 = photoUrl400;
        this.photoUrl250 = photoUrl250;
        this.photoUrl100 = photoUrl100;
        this.photoUrl75 = photoUrl75;
        this.conversationTitle = conversationTitle;
        this.conversationText = conversationText;
        this.conversation = conversation;
        this.tags = tags;
        this.id3Artist = id3Artist;
        this.id3Album = id3Album;
        this.id3Year = id3Year;
        this.id3Track = id3Track;
        this.id3Title = id3Title;
        this.audioEmbed = audioEmbed;
        this.audioPlayer = audioPlayer;
        this.regularTitle = regularTitle;
        this.regularBody = regularBody;
        this.linkDescription = linkDescription;
        this.linkText = linkText;
        this.linkUrl = linkUrl;
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

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteSource() {
        return quoteSource;
    }

    public void setQuoteSource(String quoteSource) {
        this.quoteSource = quoteSource;
    }

    public String getPhotoUrl1280() {
        return photoUrl1280;
    }

    public void setPhotoUrl1280(String photoUrl1280) {
        this.photoUrl1280 = photoUrl1280;
    }

    public String getPhotoUrl500() {
        return photoUrl500;
    }

    public void setPhotoUrl500(String photoUrl500) {
        this.photoUrl500 = photoUrl500;
    }

    public String getPhotoUrl400() {
        return photoUrl400;
    }

    public void setPhotoUrl400(String photoUrl400) {
        this.photoUrl400 = photoUrl400;
    }

    public String getPhotoUrl250() {
        return photoUrl250;
    }

    public void setPhotoUrl250(String photoUrl250) {
        this.photoUrl250 = photoUrl250;
    }

    public String getPhotoUrl100() {
        return photoUrl100;
    }

    public void setPhotoUrl100(String photoUrl100) {
        this.photoUrl100 = photoUrl100;
    }

    public String getPhotoUrl75() {
        return photoUrl75;
    }

    public void setPhotoUrl75(String photoUrl75) {
        this.photoUrl75 = photoUrl75;
    }

    public String getConversationTitle() {
        return conversationTitle;
    }

    public void setConversationTitle(String conversationTitle) {
        this.conversationTitle = conversationTitle;
    }

    public String getConversationText() {
        return conversationText;
    }

    public void setConversationText(String conversationText) {
        this.conversationText = conversationText;
    }

    public List<ConversationJson> getConversation() {
        return conversation;
    }

    public void setConversation(List<ConversationJson> conversation) {
        this.conversation = conversation;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId3Artist() {
        return id3Artist;
    }

    public void setId3Artist(String id3Artist) {
        this.id3Artist = id3Artist;
    }

    public String getId3Album() {
        return id3Album;
    }

    public void setId3Album(String id3Album) {
        this.id3Album = id3Album;
    }

    public String getId3Year() {
        return id3Year;
    }

    public void setId3Year(String id3Year) {
        this.id3Year = id3Year;
    }

    public String getId3Track() {
        return id3Track;
    }

    public void setId3Track(String id3Track) {
        this.id3Track = id3Track;
    }

    public String getId3Title() {
        return id3Title;
    }

    public void setId3Title(String id3Title) {
        this.id3Title = id3Title;
    }

    public String getAudioEmbed() {
        return audioEmbed;
    }

    public void setAudioEmbed(String audioEmbed) {
        this.audioEmbed = audioEmbed;
    }

    public String getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(String audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public String getRegularTitle() {
        return regularTitle;
    }

    public void setRegularTitle(String regularTitle) {
        this.regularTitle = regularTitle;
    }

    public String getRegularBody() {
        return regularBody;
    }

    public void setRegularBody(String regularBody) {
        this.regularBody = regularBody;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }
}
