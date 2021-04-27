package com.yusufpats.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @ColumnInfo(name = "uid")
    @PrimaryKey
    int uid;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "body")
    String body;

    @ColumnInfo(name = "createdAt")
    long createdTimestamp;




}
