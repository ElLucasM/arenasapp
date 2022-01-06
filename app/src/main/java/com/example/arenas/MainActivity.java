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

        final Button start = findViewById(R.id.start);
        final Button admin = findViewById(R.id.admin);
        Intent i = new Intent(this, MapNavigation.class);
        Intent adminIntent = new Intent(this, AdminActivity.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(adminIntent);
            }
        });
    }


}