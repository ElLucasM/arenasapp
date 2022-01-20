package com.example.arenas;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;

import org.w3c.dom.Text;

import java.util.List;

public class RunningStateActivity extends AppCompatActivity {

    private ArenasDatabase db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_state);
        db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        List<Solar> solares = db.solarDAO().getAllSolares();
        final Button[] buttons = new Button[22];
        
        //DECLARO BOTON
        buttons[0]  = findViewById(R.id.buttonsolar1);
        buttons[1] = findViewById(R.id.buttonsolar2);
        buttons[2] = findViewById(R.id.buttonsolar3);
        buttons[3] = findViewById(R.id.buttonsolar4);
        buttons[4] = findViewById(R.id.buttonsolar5);
        buttons[5] = findViewById(R.id.buttonsolar6);
        buttons[6] = findViewById(R.id.buttonsolar7);
        buttons[7] = findViewById(R.id.buttonsolar8);
        buttons[8] = findViewById(R.id.buttonsolar9);
        buttons[9]  = findViewById(R.id.buttonsolar10);
        buttons[10] = findViewById(R.id.buttonsolar11);
        buttons[11] = findViewById(R.id.buttonsolar12);
        buttons[12] = findViewById(R.id.buttonsolar13);
        buttons[13] = findViewById(R.id.buttonsolar14);
        buttons[14] = findViewById(R.id.buttonsolar15);
        buttons[15] = findViewById(R.id.buttonsolar16);
        buttons[16] = findViewById(R.id.buttonsolar17);
        buttons[17] = findViewById(R.id.buttonsolar18);
        buttons[18] = findViewById(R.id.buttonsolar19);
        buttons[19] = findViewById(R.id.buttonsolar20);
        buttons[20] = findViewById(R.id.buttonsolar21);
        buttons[21] = findViewById(R.id.buttonsolar22);

        final TextView[] solarPriceTags = new TextView[22];

        solarPriceTags[0] = findViewById(R.id.solarPriceTag1);
        solarPriceTags[1] = findViewById(R.id.solarPriceTag2);
        solarPriceTags[2] = findViewById(R.id.solarPriceTag3);
        solarPriceTags[3] = findViewById(R.id.solarPriceTag4);
        solarPriceTags[4] = findViewById(R.id.solarPriceTag5);
        solarPriceTags[5] = findViewById(R.id.solarPriceTag6);
        solarPriceTags[6] = findViewById(R.id.solarPriceTag7);
        solarPriceTags[7] = findViewById(R.id.solarPriceTag8);
        solarPriceTags[8] = findViewById(R.id.solarPriceTag9);
        solarPriceTags[9]  = findViewById(R.id.solarPriceTag10);
        solarPriceTags[10]  = findViewById(R.id.solarPriceTag11);
        solarPriceTags[11]  = findViewById(R.id.solarPriceTag12);
        solarPriceTags[12]  = findViewById(R.id.solarPriceTag13);
        solarPriceTags[13]  = findViewById(R.id.solarPriceTag14);
        solarPriceTags[14]  = findViewById(R.id.solarPriceTag15);
        solarPriceTags[15]  = findViewById(R.id.solarPriceTag16);
        solarPriceTags[16]  = findViewById(R.id.solarPriceTag17);
        solarPriceTags[17]  = findViewById(R.id.solarPriceTag18);
        solarPriceTags[18]  = findViewById(R.id.solarPriceTag19);
        solarPriceTags[19]  = findViewById(R.id.solarPriceTag20);
        solarPriceTags[20]  = findViewById(R.id.solarPriceTag21);
        solarPriceTags[21]  = findViewById(R.id.solarPriceTag22);
    
        String color;
        
        for(int i = 0; i<22 ;i++){
            Solar solar = solares.get(i);
            solarPriceTags[i].setText(String.format("Solar %d    $%d",solar.id,solar.price));
            switch (solar.status){
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
                default:
                    color = "#1958E40B";
            }
            buttons[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)));
        }

    }
}
