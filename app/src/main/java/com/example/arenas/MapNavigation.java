package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MapNavigation extends AppCompatActivity {

    private ArenasDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //obligatorio start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);
        setBackAsBack();


        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        //DECLARO BOTON
        final Button buttonsolar1 = findViewById(R.id.buttonsolar1);
        final Button buttonsolar2 = findViewById(R.id.buttonsolar2);
        final Button buttonsolar3 = findViewById(R.id.buttonsolar3);
        final Button buttonsolar4 = findViewById(R.id.buttonsolar4);
        final Button buttonsolar5 = findViewById(R.id.buttonsolar5);
        final Button buttonsolar6 = findViewById(R.id.buttonsolar6);
        final Button buttonsolar7 = findViewById(R.id.buttonsolar7);
        final Button buttonsolar8 = findViewById(R.id.buttonsolar8);
        final Button buttonsolar9 = findViewById(R.id.buttonsolar9);
        final Button buttonsolar10 = findViewById(R.id.buttonsolar10);
        final Button buttonsolar11 = findViewById(R.id.buttonsolar11);
        final Button buttonsolar12 = findViewById(R.id.buttonsolar12);
        final Button buttonsolar13 = findViewById(R.id.buttonsolar13);
        final Button buttonsolar14 = findViewById(R.id.buttonsolar14);
        final Button buttonsolar15 = findViewById(R.id.buttonsolar15);
        final Button buttonsolar16 = findViewById(R.id.buttonsolar16);
        final Button buttonsolar17 = findViewById(R.id.buttonsolar17);
        final Button buttonsolar18 = findViewById(R.id.buttonsolar18);
        final Button buttonsolar19 = findViewById(R.id.buttonsolar19);
        final Button buttonsolar20 = findViewById(R.id.buttonsolar20);
        final Button buttonsolar21 = findViewById(R.id.buttonsolar21);
        final Button buttonsolar22 = findViewById(R.id.buttonsolar22);

        final FloatingActionButton back = findViewById(R.id.back);
        final FloatingActionButton interestpointsbutton = findViewById(R.id.interestpointsbutton);
        final FloatingActionButton contractbutton = findViewById(R.id.contractbutton);
        final FloatingActionButton photosbutton = findViewById(R.id.photosbutton);
        final FloatingActionButton priceevolutionbutton = findViewById(R.id.priceevolutionbutton);

        final ConstraintLayout solarinfo = findViewById(R.id.solarinfo);

        final TextView solartitle = findViewById(R.id.solartitle);
        final TextView solararea = findViewById(R.id.solararea);
        final TextView solarstatus = findViewById(R.id.solarstatus);
        final ImageView solarareaimage = findViewById(R.id.solarareaimage);

        final Button[] buttons = new Button[22];
        buttons[0] = buttonsolar1;
        buttons[1] = buttonsolar2;
        buttons[2] = buttonsolar3;
        buttons[3] = buttonsolar4;
        buttons[4] = buttonsolar5;
        buttons[5] = buttonsolar6;
        buttons[6] = buttonsolar7;
        buttons[7] = buttonsolar8;
        buttons[8] = buttonsolar9;
        buttons[9] = buttonsolar10;
        buttons[10] = buttonsolar11;
        buttons[11] = buttonsolar12;
        buttons[12] = buttonsolar13;
        buttons[13] = buttonsolar14;
        buttons[14] = buttonsolar15;
        buttons[15] = buttonsolar16;
        buttons[16] = buttonsolar17;
        buttons[17] = buttonsolar18;
        buttons[18] = buttonsolar19;
        buttons[19] = buttonsolar20;
        buttons[20] = buttonsolar21;
        buttons[21] = buttonsolar22;

        for (int i = 0;i < buttons.length;i++) {
            String color = "#19000000";
            String state = db.solarDAO().findSolarById(i+1).status;;
            switch(state){
                case "libre":
                    color = "#1958E40B";
                    break;
                case "comprado":
                    color = "#33FF0000";
                    break;
                case "reservado":
                    color = "#33FFAA00";
                    break;
                case "construido":
                    color = "#330090FF";
                    break;
            }
            buttons[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)));
        }




        //SET EVENTO
        ObjectAnimator fadeInBack = ObjectAnimator.ofFloat(back, "translationX", 0f);
        ObjectAnimator interestpointsFade = ObjectAnimator.ofFloat(interestpointsbutton, "translationY", 0f);
        ObjectAnimator contractFade = ObjectAnimator.ofFloat(contractbutton, "translationY", 0f);
        ObjectAnimator photosFade = ObjectAnimator.ofFloat(photosbutton, "translationY", 0f);

        interestpointsFade.setStartDelay(0);
        interestpointsFade.setDuration(400);
        contractFade.setStartDelay(150);
        contractFade.setDuration(400);
        photosFade.setStartDelay(300);
        photosFade.setDuration(400);
        fadeInBack.setStartDelay(450);
        fadeInBack.setDuration(400);

        interestpointsFade.start();
        contractFade.start();
        photosFade.start();
        fadeInBack.start();
        final TextView solarPrice = findViewById(R.id.solarprice);

        //

        for (int i = 0;i < buttons.length;i++) {
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ObjectAnimator interestpointsFadeback = ObjectAnimator.ofFloat(interestpointsbutton, "translationY", 200f);
                    ObjectAnimator contractFadeback = ObjectAnimator.ofFloat(contractbutton, "translationY", 200f);
                    ObjectAnimator photosFadeback = ObjectAnimator.ofFloat(photosbutton, "translationY", 200f);

                    interestpointsFadeback.setStartDelay(300);
                    interestpointsFadeback.setDuration(400);
                    contractFadeback.setStartDelay(150);
                    contractFadeback.setDuration(400);
                    photosFadeback.setStartDelay(0);
                    photosFadeback.setDuration(400);

                    photosFadeback.start();
                    contractFadeback.start();
                    interestpointsFadeback.start();


                    ObjectAnimator priceevolutionbuttonFade = ObjectAnimator.ofFloat(priceevolutionbutton, "translationY", 0f);
                    priceevolutionbuttonFade.setStartDelay(450);
                    priceevolutionbuttonFade.setDuration(400);
                    priceevolutionbuttonFade.start();

                    Solar selectedSolar = db.solarDAO().findSolarById(finalI+1);

                    moveMap(buttons[finalI], view, back, buttons, interestpointsFade, contractFade, photosFade);
                    hideButtons(buttons);
                    solartitle.setText("SOLAR N# " + (finalI +1));
                    ObjectAnimator solarInfoAnimation = ObjectAnimator.ofFloat(solarinfo, "translationX", 0f);
                    solarInfoAnimation.setDuration(250);
                    solarInfoAnimation.start();
                    solarPrice.setText(String.format("Precio: %d US$", selectedSolar.price));
                    solararea.setText(String.valueOf(selectedSolar.area) + "m²");
                    String str = selectedSolar.status;
                    String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
                    solarstatus.setText(cap);
                    switch(str){
                        case "libre":
                            solarstatus.setTextColor(Color.parseColor("#78FF3D"));
                            break;
                        case "comprado":
                            solarstatus.setTextColor(Color.parseColor("#FF2929"));
                            break;
                        case "reservado":
                            solarstatus.setTextColor(Color.parseColor("#FFDB29"));
                            break;
                        case "construido":
                            solarstatus.setTextColor(Color.parseColor("#3ABAFF"));
                            break;
                    }

                    int img = 0;
                    switch(finalI+1){
                        case 1:
                            img = R.drawable.solarareaimg1;
                            break;
                        case 2:
                            img = R.drawable.solarareaimg2;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            img = R.drawable.solarareaimgcommon;
                            break;
                        case 12:
                            img = R.drawable.solarareaimg12;
                            break;
                        case 13:
                            img = R.drawable.solarareaimg13;
                            break;
                        case 14:
                            img = R.drawable.solarareaimg14;
                            break;
                        case 22:
                            img = R.drawable.solarareaimg22;
                            break;
                    }
                    solarareaimage.setImageResource(img);

                    priceevolutionbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setPriceEvolutionGraphic(selectedSolar);
                        }
                    });
                }
            });
        }

    }

    private void moveMap(Button button, View view, FloatingActionButton back, Button[] buttons, ObjectAnimator interestpointsFade, ObjectAnimator contractFade, ObjectAnimator photosFade){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetMap();


                interestpointsFade.setStartDelay(100);
                interestpointsFade.setDuration(400);
                contractFade.setStartDelay(250);
                contractFade.setDuration(400);
                photosFade.setStartDelay(500);
                photosFade.setDuration(400);

                interestpointsFade.start();
                contractFade.start();
                photosFade.start();

                final FloatingActionButton priceevolutionbutton = findViewById(R.id.priceevolutionbutton);
                ObjectAnimator priceevolutionbuttonFadeback = ObjectAnimator.ofFloat(priceevolutionbutton, "translationY", 200f);
                priceevolutionbuttonFadeback.setStartDelay(0);
                priceevolutionbuttonFadeback.setDuration(400);
                priceevolutionbuttonFadeback.start();

                showButtons(buttons);
                final ConstraintLayout solarinfo = findViewById(R.id.solarinfo);
                ObjectAnimator solarInfoAnimation = ObjectAnimator.ofFloat(solarinfo, "translationX", 350f);
                solarInfoAnimation.setDuration(250);
                solarInfoAnimation.start();
                setBackAsBack();
            }
        });
        int[] location = new int[2];
        button.getLocationInWindow(location);
        int x = location[0] + view.getWidth() / 2;
        int y = location[1] + view.getHeight() / 2;
        float newScale = 3.5f;
        float newX = x*-3.5f+2100;
        float newY = y*-3.5f+1300;
        View map_view = findViewById(R.id.map);
        ArrayList<ObjectAnimator> arrayListObjectAnimators = new ArrayList<ObjectAnimator>();
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(map_view, "translationX", newX);
        setTerreno0X.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0X);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(map_view, "translationY", newY);
        setTerreno0Y.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Y);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(map_view, "scaleX", newScale);
        setTerreno0Zx.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Zx);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(map_view, "scaleY", newScale);
        setTerreno0Zy.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Zy);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        //zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        ObjectAnimator[] objectAnimators = arrayListObjectAnimators.toArray(new ObjectAnimator[arrayListObjectAnimators.size()]);
        zoomInTerreno0.playTogether(objectAnimators);
        zoomInTerreno0.start();
    }

    private void resetMap(){
        View map_view = findViewById(R.id.map);
        ArrayList<ObjectAnimator> arrayListObjectAnimators = new ArrayList<ObjectAnimator>();
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(map_view, "translationX", 0f);
        setTerreno0X.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0X);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(map_view, "translationY", 0f);
        setTerreno0Y.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Y);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(map_view, "scaleX", 1f);
        setTerreno0Zx.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Zx);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(map_view, "scaleY", 1f);
        setTerreno0Zy.setDuration(500);
        arrayListObjectAnimators.add(setTerreno0Zy);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        //zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        ObjectAnimator[] objectAnimators = arrayListObjectAnimators.toArray(new ObjectAnimator[arrayListObjectAnimators.size()]);
        zoomInTerreno0.playTogether(objectAnimators);
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

    private void setPriceEvolutionGraphic(Solar solar){
        List<Price> prices;
        prices = db.solarDAO().getPrices(solar.id).get(0).prices;
        PriceGraphDialog.showPriceGraph(this, this,solar,prices);
    }

    private void hideButtons(Button[] buttons) {
        for (int i = 0;i < buttons.length;i++) {
            hideButton(buttons[i]);
        }
    }

    private void showButtons(Button[] buttons) {
        for (int i = 0;i < buttons.length;i++) {
            showButton(buttons[i]);
        }
    }

    private void hideButton(Button button){
        button.setAlpha(0f);
        button.setEnabled(false);
    }

    private void showButton(Button button){
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(findViewById(button.getId()),"alpha",1f);
        fadeOut.setDuration(100);
        fadeOut.setStartDelay(400);
        fadeOut.start();
        button.setEnabled(true);
    }

}