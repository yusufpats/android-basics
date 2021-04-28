package com.yusufpats.menutypes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenuActivity extends AppCompatActivity {

    private boolean shouldRemoveSearch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OptionsMenuActivity.this.setContentView(R.layout.activity_options_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = OptionsMenuActivity.this.getMenuInflater();
        menuInflater.inflate(R.menu.nested_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(shouldRemoveSearch){
            menu.removeItem(R.id.search_action);
            return true;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.delete_action) {
            Toast.makeText(OptionsMenuActivity.this, "Delete", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.search_action) {
            Toast.makeText(OptionsMenuActivity.this, "Search", Toast.LENGTH_SHORT).show();
        }else if (itemId == R.id.remove_search_action) {

            // This will call the `onPrepareOptionsMenu` and update the menu items
            shouldRemoveSearch = true;
            OptionsMenuActivity.this.invalidateOptionsMenu();

            Toast.makeText(OptionsMenuActivity.this, "removed the search option", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}