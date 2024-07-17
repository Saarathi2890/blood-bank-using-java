package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity5 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main5);
            Button button=findViewById(R.id.button);
            Button button2=findViewById(R.id.button2);
            Button button3=findViewById(R.id.button3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fm=getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.fragmentContainerView2,BlankFragment.class,null).setReorderingAllowed(true).addToBackStack("name").commit();

                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fm=getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.fragmentContainerView2,BlankFragment2.class,null).setReorderingAllowed(true).addToBackStack("name").commit();

                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fm = getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.fragmentContainerView2, BlankFragment3.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                    Intent in=new Intent(MainActivity5.this, MainActivity6.class);
                    startActivity(in);

                }
            });
        }
    }
