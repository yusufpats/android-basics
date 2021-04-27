package com.yusufpats.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class SimpleAlertDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        // 1. configure dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle("Hello");
        alertDialogBuilder.setMessage("How are you?");
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);

        alertDialogBuilder.setPositiveButton("Good", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "That's good to hear", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Bad", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Im sorry to hear that", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNeutralButton("Can't Say", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "That's weird", Toast.LENGTH_SHORT).show();
            }
        });

        // 2. Create and return  the dialog
        return alertDialogBuilder.create();
    }
}
