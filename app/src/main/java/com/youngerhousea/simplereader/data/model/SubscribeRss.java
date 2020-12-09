package com.youngerhousea.simplereader.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(tableName = "subscribeRssList",
        foreignKeys = @ForeignKey(
        entity = Group.class,
        parentColumns = "groupId",
        childColumns = "groupId"),
indices = {@Index(value = "groupId")})
public class SubscribeRss {

    @PrimaryKey(autoGenerate = true)
    private int subscribeRssId;

    private int groupId;

    @NotNull
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

    public @NotNull String getUrl() {
        return url;
    }

    public void setUrl(@NotNull String url) {
        this.url = url;
    }


    public SubscribeRss(int groupId, @NotNull String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
