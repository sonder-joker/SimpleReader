package com.youngerhousea.simplereader.data.model.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import lombok.Data;


@Entity(tableName = "rssUrlList",
        foreignKeys = @ForeignKey(
                entity = Group.class,
                parentColumns = "groupId",
                childColumns = "groupId"),
        indices = {@Index(value = "groupId")})
@Data
public class RssUrl {
    @PrimaryKey(autoGenerate = true)
    private Integer rssUrlId;

    private Integer groupId;

    @NotNull
    private String url;

    public RssUrl(Integer groupId, @NotNull String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
