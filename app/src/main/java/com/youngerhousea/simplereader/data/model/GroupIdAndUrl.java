package com.youngerhousea.simplereader.data.model;

public class GroupIdAndUrl {
    private Integer groupId;
    private String url;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GroupIdAndUrl(Integer groupId, String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
