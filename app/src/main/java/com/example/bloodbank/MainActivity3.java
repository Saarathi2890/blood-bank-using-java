package com.example.bloodbank;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText e1, e2, e3;
    private Button button2;
    private Handler handler;

    // Database Helper Class
    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "bloodBankDB";
        private static final String TABLE_NAME = "donors";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_EMAIL = "email";
        private static final String COLUMN_PASSWORD = "password";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_PASSWORD + " TEXT"
                    + ")";
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public void addDonor(String name, String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, name);
            values.put(COLUMN_EMAIL, email);
            values.put(COLUMN_PASSWORD, password);

            db.insert(TABLE_NAME, null, values);
            db.close();
        }

        public String getAllData() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

            StringBuilder data = new StringBuilder();
            while (cursor.moveToNext()) {
                data.append("ID: ").append(cursor.getString(0)).append("\n");
                data.append("Name: ").append(cursor.getString(1)).append("\n");
                data.append("Email: ").append(cursor.getString(2)).append("\n");
                data.append("Password: ").append(cursor.getString(3)).append("\n\n");
            }

            cursor.close();
            return data.toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressBar = findViewById(R.id.progressBar);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextTextEmailAddress);
        e3 = findViewById(R.id.editTextTextPassword);
        button2 = findViewById(R.id.button2);
        handler = new Handler();

        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity3.this);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                String name = e1.getText().toString();
                String email = e2.getText().toString();
                String password = e3.getText().toString();

                // Insert data into SQLite database
                dbHelper.addDonor(name, email, password);

                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putExtra("key", name);
                i.putExtra("key1",email);// Sending name as an extra to display in MainActivity4
                startActivity(i);

                // Delay hiding the progress bar
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                }, 4000); // Adjust the delay time in milliseconds
            }
        });
    }
}
