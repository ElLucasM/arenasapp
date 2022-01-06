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