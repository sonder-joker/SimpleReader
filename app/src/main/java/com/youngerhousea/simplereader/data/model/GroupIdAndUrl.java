package com.youngerhousea.simplereader.data.model;

public class GroupIdAndUrl {
    private int groupId;
    private String url;

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

    public GroupIdAndUrl(int groupId, String url) {
        this.groupId = groupId;
        this.url = url;
    }
}
