package com.youngerhousea.simplereader.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "groupList")
public class Group {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "group_id")
    private int groupId;

    @ColumnInfo(name = "group_name")
    private String groupName;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
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
