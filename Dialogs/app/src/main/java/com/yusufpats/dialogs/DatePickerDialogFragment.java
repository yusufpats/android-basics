package com.yusufpats.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DatePickerDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Context mContext = getContext();

        // 1. Create and return the date-picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                Toast.makeText(getContext(), "Selected Date - " + d + "/" + (m+1) + "/" + y, Toast.LENGTH_SHORT).show();
            }
        },2021, 3, 22);

        // 2. return created dialog
        return datePickerDialog;
    }
}
