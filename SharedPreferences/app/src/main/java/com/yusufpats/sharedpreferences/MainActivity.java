package com.yusufpats.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// create and get object of shared preferences - myPrefs.xml
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        /// CRUD - Create, Read, Update, Delete operations
        // 1. Read
        String username = sharedPreferences.getString("Username", "defaultValue");
        int highScore = sharedPreferences.getInt("highScore", 0);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);


        // 2. Create / Write
        // 3. Update
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "Yusuf Patrawala");
        editor.putBoolean("isLoggedIn", true);
        editor.apply();


        // 4. Delete - Single entry (key)
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor.remove("username");
        editor1.apply();

        // 4. Delete - All entries
        SharedPreferences.Editor editor2 = sharedPreferences.edit();
        editor2.clear();
        editor2.apply();
    }
}