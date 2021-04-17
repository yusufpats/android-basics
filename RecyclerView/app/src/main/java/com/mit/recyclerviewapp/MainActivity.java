package com.mit.recyclerviewapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Need some Data - Online / Offline - Below code only for demo (creating dummy data)
        ArrayList<Contact> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Contact c = new Contact(
                    "Yusuf" + i,
                    "Patrawala" + i,
                    "+919876543" + i,
                    i
            );

            dataList.add(c);
        }

        // 2. Add recycler view to xml -> and bind that in java
        RecyclerView contactsRecyclerView = this.findViewById(R.id.contacts_recycler_view);

        // 3. Add a LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 3, RecyclerView.VERTICAL, false);
        contactsRecyclerView.setLayoutManager(linearLayoutManager);


        // 4. Attach an Adapter
        ContactsAdapter contactsAdapter = new ContactsAdapter(dataList);
        contactsRecyclerView.setAdapter(contactsAdapter);

    }
}