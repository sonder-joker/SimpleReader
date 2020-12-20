package com.youngerhousea.simplereader.data.model;

import lombok.Data;

@Data
public class GroupIdAndRssUrl {
    private Integer groupId;
    private String url;

    public GroupIdAndRssUrl(Integer groupId, String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
