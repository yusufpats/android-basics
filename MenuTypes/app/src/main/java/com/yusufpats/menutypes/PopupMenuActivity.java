package com.yusufpats.menutypes;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class PopupMenuActivity extends AppCompatActivity {

    private boolean shouldRemoveSearch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        TextView popupTextView = findViewById(R.id.popup_text_view);
        TextView popupTextViewAnchor = findViewById(R.id.popup_text_view_anchor);

        popupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, popupTextViewAnchor);

                // 1. Create an add inflate a menu
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.app_menu, popupMenu.getMenu());

                if(shouldRemoveSearch){
                    popupMenu.getMenu().removeItem(R.id.search_action);
                }

                // 2. Add item selected
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();

                        if (itemId == R.id.delete_action) {
                            Toast.makeText(PopupMenuActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                        } else if (itemId == R.id.search_action) {
                            Toast.makeText(PopupMenuActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        }else if (itemId == R.id.remove_search_action) {
                            shouldRemoveSearch = true;
                            Toast.makeText(PopupMenuActivity.this, "removed the search option", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });

                // 3 . Show pop-up menu
                popupMenu.show();
            }
        });
    }
}