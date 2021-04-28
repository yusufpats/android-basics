package com.yusufpats.menutypes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ContextFloatingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_floating_menu);

        ImageView imageView = this.findViewById(R.id.icon_image_view);

        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = ContextFloatingMenu.this.getMenuInflater();
        menuInflater.inflate(R.menu.app_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.delete_action) {
            Toast.makeText(ContextFloatingMenu.this, "Delete", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.search_action) {
            Toast.makeText(ContextFloatingMenu.this, "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }





}