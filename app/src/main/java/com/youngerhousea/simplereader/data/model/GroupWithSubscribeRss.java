package com.youngerhousea.simplereader.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class GroupWithSubscribeRss {

    @Embedded
    private Group group;

    @Relation(
            parentColumn = "groupId",
            entityColumn = "groupId",
            entity = SubscribeRss.class,
            projection = {"url"}
    )
    private List<String> urls;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
