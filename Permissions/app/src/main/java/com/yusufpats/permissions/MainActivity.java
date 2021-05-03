package com.yusufpats.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_READ_CONTACTS_CODE = 5253;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button selectSOSContactsButton = this.findViewById(R.id.select_sos_contacts_button);
        selectSOSContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContactPicker();
            }
        });
    }

    private void showContactPicker(){

        // 1. Check the platform
        if(Build.VERSION.SDK_INT <= LOLLIPOP){
            openContactPicker();
            return;
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            openContactPicker();
        } else {

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                    // In an educational UI, explain to the user why your app requires this
                    // permission for a specific feature to behave as expected. In this UI,
                    // include a "cancel" or "no thanks" button that allows the user to
                    // continue using your app without granting the permission.
                    Toast.makeText(this, "Contacts permission is necessary to select SOS contacts",
                            Toast.LENGTH_SHORT).show();
                }
                    // You can directly ask for the permission.
                    // The registered ActivityResultCallback gets the result of this request.
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_READ_CONTACTS_CODE);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 5253) {
            // Received permission result for read contacts permission

            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted. Continue with displaying contacts
                openContactPicker();
            } else {
                // Explain to the user that the feature is unavailable because
                // the features requires a permission that the user has denied.
                // At the same time, respect the user's decision. Don't link to
                // system settings in an effort to convince the user to change
                // their decision.
                Toast.makeText(this, "Contact permission was not granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Other 'case' lines to check for other
            // permissions this app might request.
        }
    }


    private void openContactPicker(){
        //TODO: Some code to show contact list in your application
        Toast.makeText(this, "Hurray! We can show contact list", Toast.LENGTH_SHORT).show();
    }
}