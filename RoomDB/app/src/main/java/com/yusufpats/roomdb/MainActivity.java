package com.yusufpats.roomdb;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Create object of DB
        NotesAppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                NotesAppDatabase.class,
                "notes-db"
        ).build();


        // 2. Get DAO object
        NotesDao notesDao = db.notesDao();


        //3. Get data to be stored
        Note note = new Note();
        note.uid = 1;
        note.title = "Note 1";
        note.body = "Note 1 Description";
        note.createdTimestamp = System.currentTimeMillis();

        // 4. Call insert method of Dao to store data entry as row in table
        new Thread(new Runnable() {
            @Override
            public void run() {
                // A. Insert Note object to DB
                notesDao.insertNote(note);

                // B. Fetch list of all Notes from DB
                List<Note> notesResult = notesDao.getAllNotes();

                // C. Perform display tasks on UI-Thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("NOTE CREATED", note.title + " created");
                        Toast.makeText(MainActivity.this, note.title + " created", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();


        Log.e("TAG", note.title);
    }
}
