package com.matuszew.data.common.model.bo;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by matuszewski on 27/04/2017.
 */

@Parcel(Parcel.Serialization.FIELD)
public class TumbleLog {

    private String title;
    private String description;
    private String name;
    private String timezone;

    public TumbleLog() {
    }

    @ParcelConstructor
    public TumbleLog(String title, String description, String name, String timezone) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.timezone = timezone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
