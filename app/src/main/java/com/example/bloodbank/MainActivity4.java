package com.example.bloodbank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {
    TextView view;
    TextView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        view =(TextView) findViewById(R.id.textView4);
        view1=(TextView) findViewById(R.id.textView2);
        Intent i=getIntent();
        String str=i.getStringExtra("var");
        String str1=i.getStringExtra("var1");
        view.setText(str);
        view1.setText(str1);
        Intent intent = getIntent();
        long selectedDateTimeInMillis = intent.getLongExtra("SELECTED_DATE_TIME", 0);

        if (selectedDateTimeInMillis != 0) {
            Date selectedDateTime = new Date(selectedDateTimeInMillis);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            String formattedDateTime = dateFormat.format(selectedDateTime);

            TextView textViewDateTime = findViewById(R.id.textView3);
            textViewDateTime.setText("Selected Date and Time: " + formattedDateTime);
        }
    }

    public void onClick(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity4.this);
        alertDialogBuilder.setTitle("Verify Details");
        alertDialogBuilder.setMessage("Are you sure want to donate?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // User clicked "Yes", navigate to next activity
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // User clicked "No", finish this activity (go back to previous page)
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void onclick(View view) {
        Intent i = new Intent(MainActivity4.this,MainActivity7.class);
        startActivity(i);
    }
}
