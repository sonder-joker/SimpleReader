package com.youngerhousea.simplereader.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "groupList")
public class Group {

    @PrimaryKey(autoGenerate = true)
    private Integer groupId;

    private String groupName;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
