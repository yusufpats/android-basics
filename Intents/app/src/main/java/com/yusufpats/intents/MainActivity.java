package com.yusufpats.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Explicit Intents
        setupExplicitIntentButton();

        // Implicit Intents
        setupBrowserIntentButton();
        setupEmailIntentButton();
        setupShareButton();
    }

    /**
     * EXPLICIT INTENTS BUTTON - CODE START
     */
    private void setupExplicitIntentButton() {
        Button explicitIntentButton = this.findViewById(R.id.explicit_intents_button);
        explicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. Create an intent object
                Intent intent = new Intent(MainActivity.this, StudentProfileActivity.class);

                // 2. Add Extra data parameters
                intent.putExtra("studentName","Yusuf Patrawala");
                intent.putExtra("studentRollNumber",53);

                // 3. Perform intent
                MainActivity.this.startActivity(intent);
            }
        });
    }

    /**
     * IMPLICIT - BROWSER INTENTS BUTTON - CODE START
     */
    private void setupBrowserIntentButton() {
        Button browserIntentButton = this.findViewById(R.id.browser_intents_button);
        browserIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://mitwpu.edu.in/";
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                MainActivity.this.startActivity(urlIntent);
            }
        });
    }


    /**
     * IMPLICIT - EMAIL INTENTS BUTTON - CODE START
     */
    private void setupEmailIntentButton() {
        Button emailIntentButton = this.findViewById(R.id.email_intents_button);
        emailIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        // 1: Action Type
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        /// 2: Extra Data parameters (key/values)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Text Message content");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yusufpats@gmail.com", "example@xyz.com"});

        // 3: Data TYpe (mimeType)
        emailIntent.setType("text/html");

        startActivity(emailIntent);
    }

    /**
     * IMPLICIT - SHARE INTENTS BUTTON - CODE START
     */
    private void setupShareButton() {
        Button shareIntentButton = this.findViewById(R.id.share_intents_button);
        shareIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData();
            }
        });
    }

    private void shareData() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                .setType("text/html")
                .setText("Share Text")
                .setSubject("Share Subject")
                .addEmailTo("yusufpats@gmail.com")
                .addEmailTo(new String[]{"yusufpats@gmail.com", "example@xyz.com"})
                .addEmailCc("cc@example.com")
                // Set the Uri of a file is setStream() if you want to share a file in this intent
                .setStream(null)
                .getIntent();

        startActivity(shareIntent);
    }
}