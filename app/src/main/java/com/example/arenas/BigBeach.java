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

public class BigBeach extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_beach);

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View bigbeachstart = findViewById(R.id.bigbeach_start);
        View bigbeachend = findViewById(R.id.bigbeach_end);
        View bigbeachmap = findViewById(R.id.bigbeach_map);

        ImageView bigbeachroute = findViewById(R.id.bigbeach_route);

        ObjectAnimator mapShowAlpha = ObjectAnimator.ofFloat(bigbeachmap, "Alpha", 1f);
        ObjectAnimator mapShowScaleX = ObjectAnimator.ofFloat(bigbeachmap, "ScaleX", 1f);
        ObjectAnimator mapShowScaleY = ObjectAnimator.ofFloat(bigbeachmap, "ScaleY", 1f);
        ObjectAnimator mapShowTranslationX = ObjectAnimator.ofFloat(bigbeachmap, "TranslationX", 0f);
        ObjectAnimator mapShowTranslationY = ObjectAnimator.ofFloat(bigbeachmap, "TranslationY", 0f);
        ObjectAnimator mapShowRotation = ObjectAnimator.ofFloat(bigbeachmap, "Rotation", 0f);

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

        ObjectAnimator startShowAlpha = ObjectAnimator.ofFloat(bigbeachstart, "Alpha", 1f);
        ObjectAnimator startShowScaleX = ObjectAnimator.ofFloat(bigbeachstart, "ScaleX", 1f);
        ObjectAnimator startShowScaleY = ObjectAnimator.ofFloat(bigbeachstart, "ScaleY", 1f);

        ObjectAnimator endShowAlpha = ObjectAnimator.ofFloat(bigbeachend, "Alpha", 1f);
        ObjectAnimator endShowScaleX = ObjectAnimator.ofFloat(bigbeachend, "ScaleX", 1f);
        ObjectAnimator endShowScaleY = ObjectAnimator.ofFloat(bigbeachend, "ScaleY", 1f);

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

        TextView bigbeachtext = findViewById(R.id.textBigBeachTitle);

        ObjectAnimator bigbeachtextShow = ObjectAnimator.ofFloat(bigbeachtext, "Alpha", 1f);

        bigbeachtextShow.setDuration(300);
        bigbeachtextShow.setStartDelay(2000);
        bigbeachtextShow.start();

        View bigbeachbubble = findViewById(R.id.bigbeachbubble);

        ObjectAnimator bigbeachbubbleShow = ObjectAnimator.ofFloat(bigbeachbubble, "Alpha", 1f);

        bigbeachbubbleShow.setDuration(300);
        bigbeachbubbleShow.setStartDelay(4500);
        bigbeachbubbleShow.start();

        FloatingActionButton bigbeachback = findViewById(R.id.bigbeachBack);

        Intent i = new Intent(this, MapNavigation.class);

        bigbeachback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator beachbackHide = ObjectAnimator.ofFloat(bigbeachback, "TranslationX", -150f);
                beachbackHide.setDuration(400);
                beachbackHide.start();

                ObjectAnimator beachbubbleHide = ObjectAnimator.ofFloat(bigbeachbubble, "Alpha", 0f);

                beachbubbleHide.setDuration(300);
                beachbubbleHide.setStartDelay(100);
                beachbubbleHide.start();

                ObjectAnimator beachrouteHide = ObjectAnimator.ofFloat(bigbeachroute, "Alpha", 0f);

                beachrouteHide.setDuration(300);
                beachrouteHide.setStartDelay(100);
                beachrouteHide.start();

                ObjectAnimator bigbeachstartHide = ObjectAnimator.ofFloat(bigbeachstart, "Alpha", 0f);
                ObjectAnimator bigbeachendHide = ObjectAnimator.ofFloat(bigbeachend, "Alpha", 0f);

                bigbeachstartHide.setDuration(300);
                bigbeachstartHide.setStartDelay(100);
                bigbeachstartHide.start();
                bigbeachendHide.setDuration(300);
                bigbeachendHide.setStartDelay(100);
                bigbeachendHide.start();

                ObjectAnimator bigbeachtextHide = ObjectAnimator.ofFloat(bigbeachtext, "Alpha", 0f);

                bigbeachtextHide.setDuration(300);
                bigbeachtextHide.setStartDelay(100);
                bigbeachtextHide.start();

                //

                ObjectAnimator mapHideAlpha = ObjectAnimator.ofFloat(bigbeachmap, "Alpha", 0f);
                ObjectAnimator mapHideScaleX = ObjectAnimator.ofFloat(bigbeachmap, "ScaleX", 17f);
                ObjectAnimator mapHideScaleY = ObjectAnimator.ofFloat(bigbeachmap, "ScaleY", 17f);
                ObjectAnimator mapHideTranslationX = ObjectAnimator.ofFloat(bigbeachmap, "TranslationX", 2700);
                ObjectAnimator mapHideTranslationY = ObjectAnimator.ofFloat(bigbeachmap, "TranslationY", -6100);
                ObjectAnimator mapHideRotation = ObjectAnimator.ofFloat(bigbeachmap, "Rotation", -38f);

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
                mapHideRotation.setStartDelay(750);

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

        ObjectAnimator beachbackShow = ObjectAnimator.ofFloat(bigbeachback, "TranslationX", 0f);
        beachbackShow.setStartDelay(4800);
        beachbackShow.setDuration(400);
        beachbackShow.start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bigbeachroute.setVisibility(View.VISIBLE);
                Drawable d = bigbeachroute.getDrawable();
                if (Build.VERSION.SDK_INT >= 21 && d instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) d).start();
                } else if (d instanceof AnimatedVectorDrawableCompat) {
                    ((AnimatedVectorDrawableCompat) d).start();
                }

            }
        }, 2800);




    }


}