package com.youngerhousea.simplereader.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

import lombok.Data;

@Data
public class RssUrlAndRssSource {
    @Embedded
    private RssUrl rssUrl;

    @Relation(
            parentColumn = "rssUrlId",
            entityColumn = "rssUrlId",
            entity = RssSource.class,
            projection = {"channel"}
    )
    Channel channel;
}
