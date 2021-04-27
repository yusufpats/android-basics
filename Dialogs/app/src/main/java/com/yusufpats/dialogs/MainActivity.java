package com.yusufpats.dialogs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleDialogButton = this.findViewById(R.id.simple_dialog_button);
        simpleDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleDialog();
            }
        });

        Button datePickerDialogButton = this.findViewById(R.id.date_picker_dialog_button);
        datePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        Button timePickerDialogButton = this.findViewById(R.id.time_picker_dialog_button);
        timePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }

    /**
     * Simple Dialog Fragment
     */
    private void showSimpleDialog() {
        // 1. Create object of dialog using DialogFragment
        SimpleAlertDialogFragment simpleAlertDialogFragment = new SimpleAlertDialogFragment();

        // 2. SHow dialog 
        simpleAlertDialogFragment.show(getSupportFragmentManager(), "SimpleDialog");
    }

    /**
     * Date Picker Dialog Fragment
     */
    private void showDatePickerDialog(){
        // 1. Create object of date picker dialog using DialogFragment
        DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();

        // 2. SHow dialog
        datePickerDialogFragment.show(getSupportFragmentManager(), "DatePickerDialog");
    }

    /**
     * Time Picker Dialog Fragment
     */
    private void showTimePickerDialog(){
        // 1. Create object of date picker dialog using DialogFragment
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();

        // 2. SHow dialog
        timePickerDialogFragment.show(getSupportFragmentManager(), "TimePickerDialog");
    }




}