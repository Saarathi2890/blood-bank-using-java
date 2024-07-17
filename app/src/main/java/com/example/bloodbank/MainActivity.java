package com.example.bloodbank;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int MENU_SETTINGS = R.id.action_settings;
    private static final int MENU_ABOUT = R.id.action_about;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        registerForContextMenu(findViewById(R.id.mainLayout)); // Registering the main layout for the context menu
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); // Inflate options menu resource
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == MENU_SETTINGS) {
            // Action for Settings menu item
            Intent i=new Intent(MainActivity.this, MainActivity6.class);
            startActivity(i);
            return true;
        } else if (item.getItemId() == MENU_ABOUT) {
            // Action for About menu item
            Toast.makeText(this,"About is selected",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.color_yellow) {
            textView.setTextColor(Color.YELLOW);
            Toast.makeText(this,"Yellow is selected",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color_gray) {
            textView.setTextColor(Color.GRAY);
            Toast.makeText(this,"Grey is selected",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color_cyan) {
            textView.setTextColor(Color.CYAN);
            Toast.makeText(this,"Cyan is selected",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color_red) {
            textView.setTextColor(Color.RED);
            Toast.makeText(this, "Red is selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.color_green) {
            textView.setTextColor(Color.GREEN);
            Toast.makeText(this, "Green is selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // You can set menu header with title, icon, etc.
        menu.setHeaderTitle("Choose a color");
        // Add menu items
        menu.add(Menu.NONE, R.id.color_yellow, Menu.NONE, "Yellow");
        menu.add(Menu.NONE, R.id.color_gray, Menu.NONE, "Gray");
        menu.add(Menu.NONE, R.id.color_cyan, Menu.NONE, "Cyan");
        menu.add(Menu.NONE, R.id.color_red, Menu.NONE, "Red");
        menu.add(Menu.NONE, R.id.color_green, Menu.NONE, "Green");
    }

    public void onclick(View view) {
        Intent i=new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}