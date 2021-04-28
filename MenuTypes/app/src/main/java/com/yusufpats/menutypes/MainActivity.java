package com.yusufpats.menutypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button optionsMenuActivityButton = findViewById(R.id.options_menu_activity_button);

        optionsMenuActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OptionsMenuActivity.class);
                startActivity(i);
            }
        });


        Button popUpMenuActivityButton = findViewById(R.id.popup_menu_activity_button);
        popUpMenuActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PopupMenuActivity.class);
                startActivity(i);
            }
        });

        Button contextFloatingMenuActivityButton = findViewById(R.id.context_floating_menu_activity_button);
        contextFloatingMenuActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ContextFloatingMenu.class);
                startActivity(i);
            }
        });

        Button actionModeMenuActivityButton = findViewById(R.id.action_mode_menu_activity_button);
        actionModeMenuActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActionModeActivity.class);
                startActivity(i);
            }
        });
    }
}