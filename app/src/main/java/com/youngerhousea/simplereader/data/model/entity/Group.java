package com.youngerhousea.simplereader.data.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Entity(tableName = "groupList")
@Data
public class Group {

    @PrimaryKey(autoGenerate = true)
    private Integer groupId;

    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
