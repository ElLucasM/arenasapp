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

public class Lake extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lake);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View lakestart = findViewById(R.id.lake_start);
        View lakeend = findViewById(R.id.lake_end);
        View lakemap = findViewById(R.id.lake_map);

        ImageView lakeroute = findViewById(R.id.lake_route);

        ObjectAnimator mapShowAlpha = ObjectAnimator.ofFloat(lakemap, "Alpha", 1f);
        ObjectAnimator mapShowScaleX = ObjectAnimator.ofFloat(lakemap, "ScaleX", 1f);
        ObjectAnimator mapShowScaleY = ObjectAnimator.ofFloat(lakemap, "ScaleY", 1f);
        ObjectAnimator mapShowTranslationX = ObjectAnimator.ofFloat(lakemap, "TranslationX", 0f);
        ObjectAnimator mapShowTranslationY = ObjectAnimator.ofFloat(lakemap, "TranslationY", 0f);
        ObjectAnimator mapShowRotation = ObjectAnimator.ofFloat(lakemap, "Rotation", 0f);

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

        ObjectAnimator startShowAlpha = ObjectAnimator.ofFloat(lakestart, "Alpha", 1f);
        ObjectAnimator startShowScaleX = ObjectAnimator.ofFloat(lakestart, "ScaleX", 1f);
        ObjectAnimator startShowScaleY = ObjectAnimator.ofFloat(lakestart, "ScaleY", 1f);

        ObjectAnimator endShowAlpha = ObjectAnimator.ofFloat(lakeend, "Alpha", 1f);
        ObjectAnimator endShowScaleX = ObjectAnimator.ofFloat(lakeend, "ScaleX", 1f);
        ObjectAnimator endShowScaleY = ObjectAnimator.ofFloat(lakeend, "ScaleY", 1f);

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

        TextView laketext = findViewById(R.id.textlakeTitle);

        ObjectAnimator laketextShow = ObjectAnimator.ofFloat(laketext, "Alpha", 1f);

        laketextShow.setDuration(300);
        laketextShow.setStartDelay(2000);
        laketextShow.start();

        View lakebubble = findViewById(R.id.lakebubble);

        ObjectAnimator lakebubbleShow = ObjectAnimator.ofFloat(lakebubble, "Alpha", 1f);

        lakebubbleShow.setDuration(300);
        lakebubbleShow.setStartDelay(4500);
        lakebubbleShow.start();

        FloatingActionButton lakeback = findViewById(R.id.lakeBack);

        Intent i = new Intent(this, MapNavigation.class);

        lakeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator lakebackHide = ObjectAnimator.ofFloat(lakeback, "TranslationX", -150f);
                lakebackHide.setDuration(400);
                lakebackHide.start();

                ObjectAnimator lakebubbleHide = ObjectAnimator.ofFloat(lakebubble, "Alpha", 0f);

                lakebubbleHide.setDuration(300);
                lakebubbleHide.setStartDelay(100);
                lakebubbleHide.start();

                ObjectAnimator lakerouteHide = ObjectAnimator.ofFloat(lakeroute, "Alpha", 0f);

                lakerouteHide.setDuration(300);
                lakerouteHide.setStartDelay(100);
                lakerouteHide.start();

                ObjectAnimator lakestartHide = ObjectAnimator.ofFloat(lakestart, "Alpha", 0f);
                ObjectAnimator lakeendHide = ObjectAnimator.ofFloat(lakeend, "Alpha", 0f);

                lakestartHide.setDuration(300);
                lakestartHide.setStartDelay(100);
                lakestartHide.start();
                lakeendHide.setDuration(300);
                lakeendHide.setStartDelay(100);
                lakeendHide.start();

                ObjectAnimator laketextHide = ObjectAnimator.ofFloat(laketext, "Alpha", 0f);

                laketextHide.setDuration(300);
                laketextHide.setStartDelay(100);
                laketextHide.start();

                //

                ObjectAnimator mapHideAlpha = ObjectAnimator.ofFloat(lakemap, "Alpha", 0f);
                ObjectAnimator mapHideScaleX = ObjectAnimator.ofFloat(lakemap, "ScaleX", 19f);
                ObjectAnimator mapHideScaleY = ObjectAnimator.ofFloat(lakemap, "ScaleY", 19f);
                ObjectAnimator mapHideTranslationX = ObjectAnimator.ofFloat(lakemap, "TranslationX", -4000);
                ObjectAnimator mapHideTranslationY = ObjectAnimator.ofFloat(lakemap, "TranslationY", -2900f);
                ObjectAnimator mapHideRotation = ObjectAnimator.ofFloat(lakemap, "Rotation", -38f);

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

        ObjectAnimator lakebackShow = ObjectAnimator.ofFloat(lakeback, "TranslationX", 0f);
        lakebackShow.setStartDelay(4800);
        lakebackShow.setDuration(400);
        lakebackShow.start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lakeroute.setVisibility(View.VISIBLE);
                Drawable d = lakeroute.getDrawable();
                if (Build.VERSION.SDK_INT >= 21 && d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) d).start();
                }

            }
        }, 2800);




    }


}