package com.example.arenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class AdminActivity extends AppCompatActivity {

    public static Solar selectedSolar;
    private AlertDialog alertDialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        final Button monthlyRepButton = findViewById(R.id.monthlyRepButton);
        monthlyRepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(AdminActivity.this);
                final View monthChooserView = getLayoutInflater().inflate(R.layout.month_choose_dialog, null);
                dialogBuilder.setView(monthChooserView);

                Spinner spinner = monthChooserView.findViewById(R.id.spinner);
                Button go = monthChooserView.findViewById(R.id.go);
                List<String> months = new ArrayList<>();
                List<int[]> params = new ArrayList<>();

                for (int i = LocalDate.now().getYear(); i > 2021; i--) {
                    for (int j = 5; j > 0; j--) {
                        months.add(String.format("%d/%d", j,i));
                        params.add(new int[]{j, i});
                    }
                }
                go.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdminActivity.this ,MonthlyReportActivity.class);
                        startActivity(intent);
                        MonthlyReportActivity.month = Month.of(params.get(spinner.getSelectedItemPosition())[0]);
                        MonthlyReportActivity.year = params.get(spinner.getSelectedItemPosition())[1];
                    }
                });


                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(monthChooserView.getContext(), android.R.layout.simple_spinner_item, months);
                spinner.setAdapter(arrayAdapter);

                alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
        ArenasDatabase db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        try {
            db.insertSolar(1, "libre", 10000, 802.70f);
            db.insertSolar(2, "libre", 10000, 584.64f);
            db.insertSolar(3, "libre", 10000, 510);
            db.insertSolar(4, "libre", 10000, 510);
            db.insertSolar(5, "libre", 10000, 510);
            db.insertSolar(6, "libre", 10000, 510);
            db.insertSolar(7, "libre", 10000, 510);
            db.insertSolar(8, "libre", 10000, 510);
            db.insertSolar(9, "libre", 10000, 510);
            db.insertSolar(10, "libre", 10000, 510);
            db.insertSolar(11, "libre", 10000, 510);
            db.insertSolar(12, "libre", 10000, 584.64f);
            db.insertSolar(13, "libre", 10000, 590);
            db.insertSolar(14, "libre", 10000, 584.64f);
            db.insertSolar(15, "libre", 10000, 510);
            db.insertSolar(16, "libre", 10000, 510);
            db.insertSolar(17, "libre", 10000, 510);
            db.insertSolar(18, "libre", 10000, 510);
            db.insertSolar(19, "libre", 10000, 510);
            db.insertSolar(20, "libre", 10000, 510);
            db.insertSolar(21, "libre", 10000, 510);
            db.insertSolar(22, "libre", 10000, 914.95f);

        } catch(Exception e) {
            System.out.println(e);
        }

        //db.newPrice(new Solar(13, "libre", 10000,590),15000, LocalDateTime.of(2022,4,1,0,0));
        Solar solar = db.solarDAO().findSolarById(13);
        solar.buyDate = Date.from(Instant.parse("2022-03-10T23:59:59.000Z"));
        db.solarDAO().updateSolar(solar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent(this, SolarInfoActivity.class);
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

        ArenasDatabase db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        List<Solar> solares = db.solarDAO().getAllSolares();

        for(int i = 0; i<22; i++) {
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedSolar = solares.get(finalI);
                    startActivity(intent);
                }
            });
            switch(solares.get(finalI).status){
                case "libre":
                    buttons[i].setBackgroundColor(Color.parseColor("#54000000"));
                    break;
                case "reservado":
                    buttons[i].setBackgroundColor(Color.parseColor("#54FFAA00"));
                    break;
                case "comprado":
                    buttons[i].setBackgroundColor(Color.parseColor("#54FF0000"));
                    break;
                case "construido":
                    buttons[i].setBackgroundColor(Color.parseColor("#540090FF"));
                    break;
            }

        }
    }
}