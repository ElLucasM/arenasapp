package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arenas.persistence.ArenasDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArenasDatabase db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").allowMainThreadQueries().build();
        final Button start = findViewById(R.id.start);
        Intent i = new Intent(this, MapNavigation.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
    }


}