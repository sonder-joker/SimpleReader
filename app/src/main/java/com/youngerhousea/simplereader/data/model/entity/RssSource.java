package com.youngerhousea.simplereader.data.model.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

import lombok.Data;


@Data
@Entity(tableName = "rssSourceList",
        foreignKeys = @ForeignKey(
                entity = RssUrl.class,
                parentColumns = "rssUrlId",
                childColumns = "rssUrlId"),
        indices = {@Index("rssUrlId")})
public class RssSource {
    @PrimaryKey(autoGenerate = true)
    private Integer rssSourceId;

    private Integer rssUrlId;

    private Channel channel;

    public RssSource(Integer rssUrlId, Channel channel) {
        this.rssUrlId = rssUrlId;
        this.channel = channel;
    }
}
