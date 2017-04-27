package com.matuszew.data.common.model.json;

/**
 * Created by matuszewski on 27/04/2017.
 */

public class ConversationJson {

    private String name;
    private String label;
    private String phrase;

    public ConversationJson() {
    }

    public ConversationJson(String name, String label, String phrase) {
        this.name = name;
        this.label = label;
        this.phrase = phrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
