package com.yusufpats.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesAppDatabase extends RoomDatabase {
    public abstract NotesDao notesDao();
}
