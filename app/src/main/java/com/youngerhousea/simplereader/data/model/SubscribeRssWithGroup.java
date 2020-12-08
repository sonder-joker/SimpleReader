package com.youngerhousea.simplereader.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class SubscribeRssWithGroup {
    @Embedded
    private Group group;
    @Relation(
            parentColumn = "group_id",
            entityColumn = "group_id"
    )
    private List<SubscribeRss> subscribeRssList;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<SubscribeRss> getSubscribeRssList() {
        return subscribeRssList;
    }

    public void setSubscribeRssList(List<SubscribeRss> subscribeRssList) {
        this.subscribeRssList = subscribeRssList;
    }

    public SubscribeRssWithGroup(Group group, List<SubscribeRss> subscribeRssList) {
        this.group = group;
        this.subscribeRssList = subscribeRssList;
    }
}
