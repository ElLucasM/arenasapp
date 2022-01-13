package com.example.arenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Boats extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boats);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View boatsstart = findViewById(R.id.boats_start);
        View boatsend = findViewById(R.id.boats_end);
        View boatsmap = findViewById(R.id.boats_map);

        ImageView boatsroute = findViewById(R.id.boats_route);

        ObjectAnimator mapShowAlpha = ObjectAnimator.ofFloat(boatsmap, "Alpha", 1f);
        ObjectAnimator mapShowScaleX = ObjectAnimator.ofFloat(boatsmap, "ScaleX", 1f);
        ObjectAnimator mapShowScaleY = ObjectAnimator.ofFloat(boatsmap, "ScaleY", 1f);
        ObjectAnimator mapShowTranslationX = ObjectAnimator.ofFloat(boatsmap, "TranslationX", 0f);
        ObjectAnimator mapShowTranslationY = ObjectAnimator.ofFloat(boatsmap, "TranslationY", 0f);
        ObjectAnimator mapShowRotation = ObjectAnimator.ofFloat(boatsmap, "Rotation", 0f);

        Interpolator linearInterpolator = new LinearInterpolator();
        mapShowAlpha.setInterpolator(linearInterpolator);
        mapShowScaleX.setInterpolator(linearInterpolator);
        mapShowScaleY.setInterpolator(linearInterpolator);
        mapShowTranslationX.setInterpolator(linearInterpolator);
        mapShowTranslationX.setInterpolator(linearInterpolator);
        mapShowRotation.setInterpolator(linearInterpolator);

        mapShowAlpha.setDuration(2000);
        mapShowScaleX.setDuration(2000);
        mapShowScaleY.setDuration(2000);
        mapShowTranslationX.setDuration(2000);
        mapShowTranslationY.setDuration(2000);
        mapShowRotation.setDuration(1000);

        mapShowRotation.setStartDelay(1000);

        mapShowAlpha.start();
        mapShowScaleX.start();
        mapShowScaleY.start();
        mapShowTranslationX.start();
        mapShowTranslationY.start();
        mapShowRotation.start();

        ObjectAnimator startShowAlpha = ObjectAnimator.ofFloat(boatsstart, "Alpha", 1f);
        ObjectAnimator startShowScaleX = ObjectAnimator.ofFloat(boatsstart, "ScaleX", 1f);
        ObjectAnimator startShowScaleY = ObjectAnimator.ofFloat(boatsstart, "ScaleY", 1f);

        ObjectAnimator endShowAlpha = ObjectAnimator.ofFloat(boatsend, "Alpha", 1f);
        ObjectAnimator endShowScaleX = ObjectAnimator.ofFloat(boatsend, "ScaleX", 1f);
        ObjectAnimator endShowScaleY = ObjectAnimator.ofFloat(boatsend, "ScaleY", 1f);

        startShowAlpha.setDuration(100);
        startShowScaleX.setDuration(400);
        startShowScaleY.setDuration(400);

        startShowAlpha.setStartDelay(2000);
        startShowScaleX.setStartDelay(2000);
        startShowScaleY.setStartDelay(2000);

        endShowAlpha.setDuration(100);
        endShowScaleX.setDuration(400);
        endShowScaleY.setDuration(400);

        endShowAlpha.setStartDelay(2400);
        endShowScaleX.setStartDelay(2400);
        endShowScaleY.setStartDelay(2400);

        startShowAlpha.start();
        startShowScaleX.start();
        startShowScaleY.start();

        endShowAlpha.start();
        endShowScaleX.start();
        endShowScaleY.start();

        TextView boatstext = findViewById(R.id.textBoatsTitle);

        ObjectAnimator boatstextShow = ObjectAnimator.ofFloat(boatstext, "Alpha", 1f);

        boatstextShow.setDuration(300);
        boatstextShow.setStartDelay(2000);
        boatstextShow.start();

        View boatsbubble = findViewById(R.id.boatsbubble);

        ObjectAnimator boatsbubbleShow = ObjectAnimator.ofFloat(boatsbubble, "Alpha", 1f);

        boatsbubbleShow.setDuration(300);
        boatsbubbleShow.setStartDelay(4500);
        boatsbubbleShow.start();

        FloatingActionButton boatsback = findViewById(R.id.boatsBack);

        Intent i = new Intent(this, MapNavigation.class);

        boatsback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator boatsbackHide = ObjectAnimator.ofFloat(boatsback, "TranslationX", -150f);
                boatsbackHide.setDuration(400);
                boatsbackHide.start();

                ObjectAnimator boatsbubbleHide = ObjectAnimator.ofFloat(boatsbubble, "Alpha", 0f);

                boatsbubbleHide.setDuration(300);
                boatsbubbleHide.setStartDelay(100);
                boatsbubbleHide.start();

                ObjectAnimator boatsrouteHide = ObjectAnimator.ofFloat(boatsroute, "Alpha", 0f);

                boatsrouteHide.setDuration(300);
                boatsrouteHide.setStartDelay(100);
                boatsrouteHide.start();

                ObjectAnimator boatsstartHide = ObjectAnimator.ofFloat(boatsstart, "Alpha", 0f);
                ObjectAnimator boatsendHide = ObjectAnimator.ofFloat(boatsend, "Alpha", 0f);

                boatsstartHide.setDuration(300);
                boatsstartHide.setStartDelay(100);
                boatsstartHide.start();
                boatsendHide.setDuration(300);
                boatsendHide.setStartDelay(100);
                boatsendHide.start();

                ObjectAnimator boatstextHide = ObjectAnimator.ofFloat(boatstext, "Alpha", 0f);

                boatstextHide.setDuration(300);
                boatstextHide.setStartDelay(100);
                boatstextHide.start();

                //

                ObjectAnimator mapHideAlpha = ObjectAnimator.ofFloat(boatsmap, "Alpha", 0f);
                ObjectAnimator mapHideScaleX = ObjectAnimator.ofFloat(boatsmap, "ScaleX", 10f);
                ObjectAnimator mapHideScaleY = ObjectAnimator.ofFloat(boatsmap, "ScaleY", 10f);
                ObjectAnimator mapHideTranslationX = ObjectAnimator.ofFloat(boatsmap, "TranslationX", 4250f);
                ObjectAnimator mapHideTranslationY = ObjectAnimator.ofFloat(boatsmap, "TranslationY", -2400f);
                ObjectAnimator mapHideRotation = ObjectAnimator.ofFloat(boatsmap, "Rotation", -38f);

                Interpolator linearInterpolator = new LinearInterpolator();
                mapHideAlpha.setInterpolator(linearInterpolator);
                mapHideScaleX.setInterpolator(linearInterpolator);
                mapHideScaleY.setInterpolator(linearInterpolator);
                mapHideTranslationX.setInterpolator(linearInterpolator);
                mapHideTranslationY.setInterpolator(linearInterpolator);
                mapHideRotation.setInterpolator(linearInterpolator);

                mapHideAlpha.setDuration(2000);
                mapHideScaleX.setDuration(2000);
                mapHideScaleY.setDuration(2000);
                mapHideTranslationX.setDuration(2000);
                mapHideTranslationY.setDuration(2000);
                mapHideRotation.setDuration(1000);

                mapHideAlpha.setStartDelay(500);
                mapHideScaleX.setStartDelay(500);
                mapHideScaleY.setStartDelay(500);
                mapHideTranslationX.setStartDelay(500);
                mapHideTranslationY.setStartDelay(500);
                mapHideRotation.setStartDelay(500);

                mapHideAlpha.start();
                mapHideScaleX.start();
                mapHideScaleY.start();
                mapHideTranslationX.start();
                mapHideTranslationY.start();
                mapHideRotation.start();


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(i);
                    }
                }, 2500);

            }
        });

        ObjectAnimator boatsbackShow = ObjectAnimator.ofFloat(boatsback, "TranslationX", 0f);
        boatsbackShow.setStartDelay(4800);
        boatsbackShow.setDuration(400);
        boatsbackShow.start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boatsroute.setVisibility(View.VISIBLE);
                Drawable d = boatsroute.getDrawable();
                if (Build.VERSION.SDK_INT >= 21 && d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) d).start();
                }

            }
        }, 2800);




    }


}