package com.youngerhousea.simplereader.data.model;

public class GroupNameWithUrl {
    private String groupName;
    private String url;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupNameWithUrl(String groupName, String url) {
        this.groupName = groupName;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
