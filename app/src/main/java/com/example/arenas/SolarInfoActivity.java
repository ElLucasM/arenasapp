package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;

import java.util.Locale;

public class SolarInfoActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private AlertDialog.Builder dialogBuilder;
    private Button libre, reservado, construido, comprado;
    private Solar selectedSolar;
    private ArenasDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_info);

        selectedSolar = AdminActivity.selectedSolar;
        db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        final TextView solarID = findViewById(R.id.solarID);
        solarID.setText(String.format("Solar #%d", selectedSolar.id));
        final TextView status = findViewById(R.id.status);
        final TextView area = findViewById(R.id.area);
        final TextView price = findViewById(R.id.price);
        status.setText(selectedSolar.status.toUpperCase(Locale.ROOT));
        area.setText(String.format("%d m2",selectedSolar.area));
        price.setText(String.format("%d U$S",selectedSolar.price));

        final Button statusMod = findViewById(R.id.statusMod);
        statusMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusDialog();

            }
        });
    }

    private void statusDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View statusPopupView = getLayoutInflater().inflate(R.layout.status_popup, null);
        libre = (Button) statusPopupView.findViewById(R.id.setLibre);
        reservado = (Button) statusPopupView.findViewById(R.id.setReservado);
        comprado = (Button) statusPopupView.findViewById(R.id.setComprado);
        construido = (Button) statusPopupView.findViewById(R.id.setContruido);

        buttonsColor(selectedSolar.status);

        libre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsColor("libre");
                selectedSolar.status = "libre";
            }
        });

        reservado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsColor("reservado");
                selectedSolar.status = "reservado";
            }
        });

        comprado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsColor("comprado");
                selectedSolar.status = "comprado";
            }
        });

        construido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsColor("construido");
                selectedSolar.status = "construido";
            }
        });

        dialogBuilder.setView(statusPopupView);
        alertDialog = dialogBuilder.create();
        alertDialog.show();

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                db.solarDAO().updateSolar(selectedSolar);
            }
        });
    }

    private void buttonsColor(String status){
        switch (status){
            case "libre":
                libre.setBackgroundColor(Color.GREEN);
                libre.setTextColor(Color.WHITE);
                reservado.setBackgroundColor(Color.WHITE);
                reservado.setTextColor(Color.BLACK);
                comprado.setBackgroundColor(Color.WHITE);
                comprado.setTextColor(Color.BLACK);
                construido.setBackgroundColor(Color.WHITE);
                construido.setTextColor(Color.BLACK);
                break;
            case "reservado":
                reservado.setBackgroundColor(Color.YELLOW);
                reservado.setTextColor(Color.BLACK);
                libre.setBackgroundColor(Color.WHITE);
                libre.setTextColor(Color.BLACK);
                comprado.setBackgroundColor(Color.WHITE);
                comprado.setTextColor(Color.BLACK);
                construido.setBackgroundColor(Color.WHITE);
                construido.setTextColor(Color.BLACK);
                break;
            case "comprado":
                comprado.setBackgroundColor(Color.RED);
                comprado.setTextColor(Color.WHITE);
                libre.setBackgroundColor(Color.WHITE);
                libre.setTextColor(Color.BLACK);
                reservado.setBackgroundColor(Color.WHITE);
                reservado.setTextColor(Color.BLACK);
                construido.setBackgroundColor(Color.WHITE);
                construido.setTextColor(Color.BLACK);
                break;
            case "construido":
                construido.setBackgroundColor(Color.BLUE);
                construido.setTextColor(Color.WHITE);
                libre.setBackgroundColor(Color.WHITE);
                libre.setTextColor(Color.BLACK);
                reservado.setBackgroundColor(Color.WHITE);
                reservado.setTextColor(Color.BLACK);
                comprado.setBackgroundColor(Color.WHITE);
                comprado.setTextColor(Color.BLACK);
                break;

        }
    }

}