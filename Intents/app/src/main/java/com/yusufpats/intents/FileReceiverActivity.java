package com.yusufpats.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FileReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_receiver);

        TextView pathValueTextView = this.findViewById(R.id.path_value_text_view);

        // 1. Receive the intent
        Intent intent = getIntent();

        // 2. Check intent in not null
        if (intent != null) {

            // 3. Check if the parameter with the key is present
            if (intent.hasExtra(Intent.EXTRA_STREAM)) {

                // 4. Read the value at that key and use it in our app if not null and display it in text view
                Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (uri != null) {
                    String path = uri.getPath();
                    pathValueTextView.setText(path);
                }
            }
        }
    }
}