package com.example.arenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.entities.SolarPrice;
import com.example.arenas.persistence.ArenasDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArenasDatabase db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        final Button start = findViewById(R.id.start);
        Intent i = new Intent(this, MapNavigation.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
        //db.insertSolar(13,"Disponible", 12000, 600);
        Solar solar = db.solarDAO().findSolarById(13);
        //Price price = db.priceDAO().getPrices().get(1);
        //System.out.println(price.solarId);
        List<SolarPrice> solarPrice = db.solarDAO().getPrices(13);
        for (SolarPrice sp: solarPrice) {
            for (Price price : sp.prices){
                System.out.println(price.price);
                System.out.println(price.date);
            }
            System.out.println(sp.solar.id);
        }
        db.newPrice(solar,1300);
        solarPrice = db.solarDAO().getPrices(13);
        //System.out.println(db.solarDAO().getPrices().get(2).prices.get(0).date);
    }


}