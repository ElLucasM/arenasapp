package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;


public class AdminActivity extends AppCompatActivity {

    public static Solar selectedSolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        ArenasDatabase db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        try {
            db.solarDAO().insertSolar(new Solar(1, "libre", 10000, 802.70f));
            db.solarDAO().insertSolar(new Solar(2, "libre", 10000, 584.64f));
            db.solarDAO().insertSolar(new Solar(3, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(4, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(5, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(6, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(7, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(8, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(9, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(10, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(11, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(12, "libre", 10000, 584.64f));
            db.solarDAO().insertSolar(new Solar(13, "libre", 10000, 590));
            db.solarDAO().insertSolar(new Solar(14, "libre", 10000, 584.64f));
            db.solarDAO().insertSolar(new Solar(15, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(16, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(17, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(18, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(19, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(20, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(21, "libre", 10000, 510));
            db.solarDAO().insertSolar(new Solar(22, "libre", 10000, 914.95f));

        } catch(Exception e) {
            System.out.println(e);
        }
        final Button test = findViewById(R.id.testButton);
        Intent i = new Intent(this, SolarInfoActivity.class);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSolar = db.solarDAO().findSolarById(13);
                startActivity(i);
            }
        });
    }
}