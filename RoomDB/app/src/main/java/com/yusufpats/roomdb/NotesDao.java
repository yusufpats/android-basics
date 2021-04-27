package com.yusufpats.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();
}
