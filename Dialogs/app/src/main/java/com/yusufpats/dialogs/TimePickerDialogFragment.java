package com.yusufpats.dialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TimePickerDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Context mContext = getContext();

        // 1. Create and return the time-picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                Toast.makeText(mContext, "Selected Time - " + selectedHour + ":" + selectedMinute, Toast.LENGTH_SHORT).show();
            }
        }, 10, 20, true);

        // 2. return created dialog
        return timePickerDialog;
    }
}
