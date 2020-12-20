package com.youngerhousea.simplereader.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

import java.util.List;

import lombok.Data;

@Data
public class GroupWithRssUrls {
    @Embedded
    private Group group;

    @Relation(
            parentColumn = "groupId",
            entityColumn = "groupId",
            entity = RssUrl.class,
            projection = {"url"}
    )
    private List<String> urls;
}
