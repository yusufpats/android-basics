package com.yusufpats.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // passing a reference of a Layout file to this method to set the UI layout for this activity
        this.setContentView(R.layout.activity_main);

        // Using the reference Id of the view to find the object of the  view - in this activity's layout file
        TextView textView = this.findViewById(R.id.text_view);
        Button incrementButton = this.findViewById(R.id.increment_button);


        // Use the objects to change its properties and attach listeners and callback to them
        textView.setText("Dummy Text View");

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello Im tapped", Toast.LENGTH_SHORT).show();
            }
        });


    }
}