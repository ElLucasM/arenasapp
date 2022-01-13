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

public class Beach extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View beachstart = findViewById(R.id.beach_start);
        View beachend = findViewById(R.id.beach_end);
        View beachmap = findViewById(R.id.beach_map);

        ImageView beachroute = findViewById(R.id.beach_route);

        ObjectAnimator mapShowAlpha = ObjectAnimator.ofFloat(beachmap, "Alpha", 1f);
        ObjectAnimator mapShowScaleX = ObjectAnimator.ofFloat(beachmap, "ScaleX", 1f);
        ObjectAnimator mapShowScaleY = ObjectAnimator.ofFloat(beachmap, "ScaleY", 1f);
        ObjectAnimator mapShowTranslationX = ObjectAnimator.ofFloat(beachmap, "TranslationX", 0f);
        ObjectAnimator mapShowTranslationY = ObjectAnimator.ofFloat(beachmap, "TranslationY", 0f);
        ObjectAnimator mapShowRotation = ObjectAnimator.ofFloat(beachmap, "Rotation", 0f);

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

        ObjectAnimator startShowAlpha = ObjectAnimator.ofFloat(beachstart, "Alpha", 1f);
        ObjectAnimator startShowScaleX = ObjectAnimator.ofFloat(beachstart, "ScaleX", 1f);
        ObjectAnimator startShowScaleY = ObjectAnimator.ofFloat(beachstart, "ScaleY", 1f);

        ObjectAnimator endShowAlpha = ObjectAnimator.ofFloat(beachend, "Alpha", 1f);
        ObjectAnimator endShowScaleX = ObjectAnimator.ofFloat(beachend, "ScaleX", 1f);
        ObjectAnimator endShowScaleY = ObjectAnimator.ofFloat(beachend, "ScaleY", 1f);

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

        TextView beachtext = findViewById(R.id.textBeachTitle);

        ObjectAnimator beachtextShow = ObjectAnimator.ofFloat(beachtext, "Alpha", 1f);

        beachtextShow.setDuration(300);
        beachtextShow.setStartDelay(2000);
        beachtextShow.start();

        View beachbubble = findViewById(R.id.beachbubble);

        ObjectAnimator beachbubbleShow = ObjectAnimator.ofFloat(beachbubble, "Alpha", 1f);

        beachbubbleShow.setDuration(300);
        beachbubbleShow.setStartDelay(4500);
        beachbubbleShow.start();

        FloatingActionButton beachback = findViewById(R.id.beachBack);

        Intent i = new Intent(this, MapNavigation.class);

        beachback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator beachbackHide = ObjectAnimator.ofFloat(beachback, "TranslationX", -150f);
                beachbackHide.setDuration(400);
                beachbackHide.start();

                ObjectAnimator beachbubbleHide = ObjectAnimator.ofFloat(beachbubble, "Alpha", 0f);

                beachbubbleHide.setDuration(300);
                beachbubbleHide.setStartDelay(100);
                beachbubbleHide.start();

                ObjectAnimator beachrouteHide = ObjectAnimator.ofFloat(beachroute, "Alpha", 0f);

                beachrouteHide.setDuration(300);
                beachrouteHide.setStartDelay(100);
                beachrouteHide.start();

                ObjectAnimator beachstartHide = ObjectAnimator.ofFloat(beachstart, "Alpha", 0f);
                ObjectAnimator beachendHide = ObjectAnimator.ofFloat(beachend, "Alpha", 0f);

                beachstartHide.setDuration(300);
                beachstartHide.setStartDelay(100);
                beachstartHide.start();
                beachendHide.setDuration(300);
                beachendHide.setStartDelay(100);
                beachendHide.start();

                ObjectAnimator beachtextHide = ObjectAnimator.ofFloat(beachtext, "Alpha", 0f);

                beachtextHide.setDuration(300);
                beachtextHide.setStartDelay(100);
                beachtextHide.start();

                //

                ObjectAnimator mapHideAlpha = ObjectAnimator.ofFloat(beachmap, "Alpha", 0f);
                ObjectAnimator mapHideScaleX = ObjectAnimator.ofFloat(beachmap, "ScaleX", 10f);
                ObjectAnimator mapHideScaleY = ObjectAnimator.ofFloat(beachmap, "ScaleY", 10f);
                ObjectAnimator mapHideTranslationX = ObjectAnimator.ofFloat(beachmap, "TranslationX", 4800f);
                ObjectAnimator mapHideTranslationY = ObjectAnimator.ofFloat(beachmap, "TranslationY", -850f);
                ObjectAnimator mapHideRotation = ObjectAnimator.ofFloat(beachmap, "Rotation", -38f);

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

        ObjectAnimator beachbackShow = ObjectAnimator.ofFloat(beachback, "TranslationX", 0f);
        beachbackShow.setStartDelay(4800);
        beachbackShow.setDuration(400);
        beachbackShow.start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                beachroute.setVisibility(View.VISIBLE);
                Drawable d = beachroute.getDrawable();
                if (Build.VERSION.SDK_INT >= 21 && d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) d).start();
                }

            }
        }, 2800);




    }


}