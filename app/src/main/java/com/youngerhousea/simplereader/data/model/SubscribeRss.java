package com.youngerhousea.simplereader.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "subscribeRssList",
        foreignKeys = @ForeignKey(
        entity = Group.class,
        parentColumns = "group_id",
        childColumns = "group_id"),
indices = {@Index(value = "group_id")})
public class SubscribeRss {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subscribe_rss_id")
    private int subscribeRssId;

    @ColumnInfo(name = "group_id")
    private int groupId;

    private String url;

    public int getSubscribeRssId() {
        return subscribeRssId;
    }

    public void setSubscribeRssId(int subscribeRssId) {
        this.subscribeRssId = subscribeRssId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public SubscribeRss(int groupId, String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
