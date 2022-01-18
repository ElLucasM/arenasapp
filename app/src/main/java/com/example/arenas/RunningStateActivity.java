package com.example.arenas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.arenas.persistence.ArenasDatabase;

public class RunningStateActivity extends AppCompatActivity {

    private ArenasDatabase db;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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



    }
}
