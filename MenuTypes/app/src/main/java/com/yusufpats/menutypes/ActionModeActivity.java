package com.yusufpats.menutypes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ActionModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);


        ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = ActionModeActivity.this.getMenuInflater();
                menuInflater.inflate(R.menu.app_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.delete_action) {
                    Toast.makeText(ActionModeActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.search_action) {
                    Toast.makeText(ActionModeActivity.this, "Search", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };

        ImageView imageView = this.findViewById(R.id.item_image_view);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ActionModeActivity.this.startSupportActionMode(actionModeCallback);
                return true;
            }
        });
    }
}