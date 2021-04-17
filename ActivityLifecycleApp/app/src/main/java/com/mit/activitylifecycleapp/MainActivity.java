package com.mit.activitylifecycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MA-LifecycleCallback", "onCreate()");

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count");
        }

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MA-LifecycleCallback", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MA-LifecycleCallback", "onResume()");
        /// Usages:
        /// 1. increase location sampling rate
        /// 2. start playing video
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MA-LifecycleCallback", "onPause()");
        /// Usages:
        /// 1. lower location sampling rate
        /// 2. stop playing video
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MA-LifecycleCallback", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MA-LifecycleCallback", "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }

    private void init() {
        TextView counterTextView = this.findViewById(R.id.counter_text_view);
        Button incrementButton = this.findViewById(R.id.increment_button);
        Button saveButton = this.findViewById(R.id.save_button);

        counterTextView.setText(String.valueOf(mCount));

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount++;
                counterTextView.setText(String.valueOf(mCount));
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaveCountActivity.class);
                intent.putExtra("data", 123);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}