package com.youngerhousea.simplereader.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class SubscribeRss {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    private String group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
