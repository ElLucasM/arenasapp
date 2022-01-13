package com.example.arenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final View earth = findViewById(R.id.beach_map);
        final FloatingActionButton admin = findViewById(R.id.admin);
        final ImageView logo = findViewById(R.id.logo);
        Intent i = new Intent(this, MapNavigation.class);
        Intent adminIntent = new Intent(this, AdminActivity.class);
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(earth, "scaleX", 18f);
                scaleX.setDuration(2000);
                scaleX.setStartDelay(450);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(earth, "scaleY", 18f);
                scaleY.setDuration(2000);
                scaleY.setStartDelay(450);
                ObjectAnimator rotation = ObjectAnimator.ofFloat(earth, "rotation", -36f);
                rotation.setDuration(2000);
                rotation.setStartDelay(450);
                ObjectAnimator moveX = ObjectAnimator.ofFloat(earth, "translationX", -280f);
                moveX.setDuration(2000);
                moveX.setStartDelay(450);
                ObjectAnimator moveY = ObjectAnimator.ofFloat(earth, "translationY", -70f);
                moveY.setDuration(2000);
                moveY.setStartDelay(450);
                ObjectAnimator tint = ObjectAnimator.ofFloat(earth, "alpha", 0);
                tint.setDuration(2000);
                tint.setStartDelay(450);
                ObjectAnimator hideAdmin = ObjectAnimator.ofFloat(admin, "translationY", 200f);
                hideAdmin.setDuration(250);
                ObjectAnimator hideLogo = ObjectAnimator.ofFloat(logo, "translationY", 200f);
                hideLogo.setDuration(250);
                hideLogo.setStartDelay(250);
                scaleX.start();
                scaleY.start();
                rotation.start();
                moveX.start();
                moveY.start();
                tint.start();
                hideAdmin.start();
                hideLogo.start();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(i);
                    }
                }, 2000);

            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(adminIntent);
            }
        });
    }


}