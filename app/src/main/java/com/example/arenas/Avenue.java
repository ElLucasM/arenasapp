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

public class Avenue extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avenue);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View avenuestart = findViewById(R.id.avenue_start);
        View avenueend = findViewById(R.id.avenue_end);
        View avenuemap = findViewById(R.id.avenue_map);

        ImageView avenueroute = findViewById(R.id.avenue_route);

        ObjectAnimator mapShowAlpha = ObjectAnimator.ofFloat(avenuemap, "Alpha", 1f);
        ObjectAnimator mapShowScaleX = ObjectAnimator.ofFloat(avenuemap, "ScaleX", 1f);
        ObjectAnimator mapShowScaleY = ObjectAnimator.ofFloat(avenuemap, "ScaleY", 1f);
        ObjectAnimator mapShowTranslationX = ObjectAnimator.ofFloat(avenuemap, "TranslationX", 0f);
        ObjectAnimator mapShowTranslationY = ObjectAnimator.ofFloat(avenuemap, "TranslationY", 0f);
        ObjectAnimator mapShowRotation = ObjectAnimator.ofFloat(avenuemap, "Rotation", 0f);

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

        ObjectAnimator startShowAlpha = ObjectAnimator.ofFloat(avenuestart, "Alpha", 1f);
        ObjectAnimator startShowScaleX = ObjectAnimator.ofFloat(avenuestart, "ScaleX", 1f);
        ObjectAnimator startShowScaleY = ObjectAnimator.ofFloat(avenuestart, "ScaleY", 1f);

        ObjectAnimator endShowAlpha = ObjectAnimator.ofFloat(avenueend, "Alpha", 1f);
        ObjectAnimator endShowScaleX = ObjectAnimator.ofFloat(avenueend, "ScaleX", 1f);
        ObjectAnimator endShowScaleY = ObjectAnimator.ofFloat(avenueend, "ScaleY", 1f);

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

        TextView avenuetext = findViewById(R.id.textAvenueTitle);

        ObjectAnimator avenuetextShow = ObjectAnimator.ofFloat(avenuetext, "Alpha", 1f);

        avenuetextShow.setDuration(300);
        avenuetextShow.setStartDelay(2000);
        avenuetextShow.start();

        View avenuebubble = findViewById(R.id.avenuebubble);

        ObjectAnimator avenuebubbleShow = ObjectAnimator.ofFloat(avenuebubble, "Alpha", 1f);

        avenuebubbleShow.setDuration(300);
        avenuebubbleShow.setStartDelay(4500);
        avenuebubbleShow.start();

        FloatingActionButton avenueback = findViewById(R.id.avenueBack);

        Intent i = new Intent(this, MapNavigation.class);

        avenueback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator avenuebackHide = ObjectAnimator.ofFloat(avenueback, "TranslationX", -150f);
                avenuebackHide.setDuration(400);
                avenuebackHide.start();

                ObjectAnimator avenuebubbleHide = ObjectAnimator.ofFloat(avenuebubble, "Alpha", 0f);

                avenuebubbleHide.setDuration(300);
                avenuebubbleHide.setStartDelay(100);
                avenuebubbleHide.start();

                ObjectAnimator avenuerouteHide = ObjectAnimator.ofFloat(avenueroute, "Alpha", 0f);

                avenuerouteHide.setDuration(300);
                avenuerouteHide.setStartDelay(100);
                avenuerouteHide.start();

                ObjectAnimator avenuestartHide = ObjectAnimator.ofFloat(avenuestart, "Alpha", 0f);
                ObjectAnimator avenueendHide = ObjectAnimator.ofFloat(avenueend, "Alpha", 0f);

                avenuestartHide.setDuration(300);
                avenuestartHide.setStartDelay(100);
                avenuestartHide.start();
                avenueendHide.setDuration(300);
                avenueendHide.setStartDelay(100);
                avenueendHide.start();

                ObjectAnimator avenuetextHide = ObjectAnimator.ofFloat(avenuetext, "Alpha", 0f);

                avenuetextHide.setDuration(300);
                avenuetextHide.setStartDelay(100);
                avenuetextHide.start();

                //

                ObjectAnimator mapHideAlpha = ObjectAnimator.ofFloat(avenuemap, "Alpha", 0f);
                ObjectAnimator mapHideScaleX = ObjectAnimator.ofFloat(avenuemap, "ScaleX", 9.5f);
                ObjectAnimator mapHideScaleY = ObjectAnimator.ofFloat(avenuemap, "ScaleY", 9.5f);
                ObjectAnimator mapHideTranslationX = ObjectAnimator.ofFloat(avenuemap, "TranslationX", 2450f);
                ObjectAnimator mapHideTranslationY = ObjectAnimator.ofFloat(avenuemap, "TranslationY", -1200f);
                ObjectAnimator mapHideRotation = ObjectAnimator.ofFloat(avenuemap, "Rotation", -38f);

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

        ObjectAnimator avenuebackShow = ObjectAnimator.ofFloat(avenueback, "TranslationX", 0f);
        avenuebackShow.setStartDelay(4800);
        avenuebackShow.setDuration(400);
        avenuebackShow.start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                avenueroute.setVisibility(View.VISIBLE);
                Drawable d = avenueroute.getDrawable();
                if (Build.VERSION.SDK_INT >= 21 && d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) d).start();
                }

            }
        }, 2800);




    }


}