package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //obligatorio start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);
        setBackAsBack();

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //DECLARO BOTON
        final Button button = findViewById(R.id.button);
        final FloatingActionButton back = findViewById(R.id.back);

        //SET EVENTO
        ObjectAnimator fadeInBack = ObjectAnimator.ofFloat(back, "translationX", 0f);
        fadeInBack.setDuration(250);
        fadeInBack.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(250f,-400f,1.7f);
                hideButton(button);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButton(button);
                        setBackAsBack();
                    }
                });
            }
        });
    }

    private void moveMap(float newX, float newY, float newScale){
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationX", newX);
        setTerreno0X.setDuration(500);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationY", newY);
        setTerreno0Y.setDuration(500);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleX", newScale);
        setTerreno0Zx.setDuration(500);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleY", newScale);
        setTerreno0Zy.setDuration(500);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        zoomInTerreno0.start();
    }

    private void resetMap(){
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationX", 0f);
        setTerreno0X.setDuration(500);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationY", 0f);
        setTerreno0Y.setDuration(500);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleX", 1f);
        setTerreno0Zx.setDuration(500);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleY", 1f);
        setTerreno0Zy.setDuration(500);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        zoomInTerreno0.start();
    }

    private void setBackAsBack(){
        Intent i = new Intent(this, MainActivity.class);
        final FloatingActionButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
    }

    private void hideButton(Button button){
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(findViewById(R.id.button),"alpha",0f);
        fadeOut.setDuration(100);
        fadeOut.start();
        button.setEnabled(false);
    }

    private void showButton(Button button){
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(findViewById(button.getId()),"alpha",1f);
        fadeOut.setDuration(100);
        fadeOut.setStartDelay(900);
        fadeOut.start();
        button.setEnabled(true);
    }

}