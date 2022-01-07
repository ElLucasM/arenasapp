package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;

import java.util.List;


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
        List<Solar> solares = db.solarDAO().getAllSolares();
        final Button[] buttons = new Button[22];
        buttons[0] = findViewById(R.id.solar1);
        buttons[1] = findViewById(R.id.solar2);
        buttons[2] = findViewById(R.id.solar3);
        buttons[3] = findViewById(R.id.solar4);
        buttons[4] = findViewById(R.id.solar5);
        buttons[5] = findViewById(R.id.solar6);
        buttons[6] = findViewById(R.id.solar7);
        buttons[7] = findViewById(R.id.solar8);
        buttons[8] = findViewById(R.id.solar9);
        buttons[9] = findViewById(R.id.solar10);
        buttons[10] = findViewById(R.id.solar11);
        buttons[11] = findViewById(R.id.solar12);
        buttons[12] = findViewById(R.id.solar13);
        buttons[13] = findViewById(R.id.solar14);
        buttons[14] = findViewById(R.id.solar15);
        buttons[15] = findViewById(R.id.solar16);
        buttons[16] = findViewById(R.id.solar17);
        buttons[17] = findViewById(R.id.solar18);
        buttons[18] = findViewById(R.id.solar19);
        buttons[19] = findViewById(R.id.solar20);
        buttons[20] = findViewById(R.id.solar21);
        buttons[21] = findViewById(R.id.solar22);
        Intent intent = new Intent(this, SolarInfoActivity.class);
        for(int i = 0; i<22; i++) {
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedSolar = solares.get(finalI);
                    startActivity(intent);
                }
            });

        }
    }
}