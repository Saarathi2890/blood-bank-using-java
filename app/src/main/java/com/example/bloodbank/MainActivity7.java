package com.example.bloodbank;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bloodbank.databinding.ActivityMain7Binding;

public class MainActivity7 extends AppCompatActivity {
        private ImageSwitcher imageSwitcher;
        private Button bt1,bt2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main7);
            imageSwitcher= (ImageSwitcher) findViewById(R.id.imageswitcher);
            imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
            imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
            bt1=findViewById(R.id.button2);
            bt2=findViewById(R.id.button) ;
            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView mv=new ImageView(getApplicationContext());
                    mv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    mv.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                    return mv;
                }
            });
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity7.this, "Available Now", Toast.LENGTH_SHORT).show();
                    imageSwitcher.setImageResource(R.drawable.img_3);

                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity7.this,"Less Availbility",Toast.LENGTH_LONG).show();
                    imageSwitcher.setImageResource(R.drawable.img_4);
                }
            });

        }
}

