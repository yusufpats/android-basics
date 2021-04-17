package com.yusufpats.intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        TextView nameValueTextView = this.findViewById(R.id.name_value_text_view);
        TextView rollNumberValueTextView = this.findViewById(R.id.roll_number_value_text_view);


        // 1. Receive the intent
        Intent intent = getIntent();

        // 2. Check intent in not null
        if (intent != null) {

            // 3. Check if the parameter with the key is present
            boolean hasName = intent.hasExtra("studentName");
            if (hasName) {
                // 4. Read the value at that key and use it in our app
                String name = intent.getStringExtra("studentName");
                nameValueTextView.setText(name);
            }

            boolean hasRollNumber = intent.hasExtra("studentRollNumber");
            if (hasRollNumber) {
                int rollNumber = intent.getIntExtra("studentRollNumber", 0);
                rollNumberValueTextView.setText(String.valueOf(rollNumber));
            }

        }


    }
}