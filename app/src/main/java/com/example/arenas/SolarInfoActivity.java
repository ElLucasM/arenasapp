package com.example.arenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.accessibilityservice.GestureDescription;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.entities.SolarPrice;
import com.example.arenas.persistence.ArenasDatabase;

import java.util.List;
import java.util.Locale;

public class SolarInfoActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private AlertDialog.Builder dialogBuilder;
    private Button libre, reservado, construido, comprado;
    private Solar selectedSolar;
    private ArenasDatabase db;
    private EditText priceField;
    private Button priceAccept;
    private Button priceCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_info);

        selectedSolar = AdminActivity.selectedSolar;
        db = Room.databaseBuilder(getApplicationContext(),ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        List<SolarPrice> solarPrices = db.solarDAO().getPrices(selectedSolar.id);

        final TextView solarID = findViewById(R.id.solarID);
        solarID.setText(String.format("Solar #%d", selectedSolar.id));
        dataLoad();

        final Button statusMod = findViewById(R.id.statusMod);
        statusMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusDialog();
            }
        });

        final Button priceMod = findViewById(R.id.priceMod);
        priceMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceDialog();
            }
        });

        final Button priceEvo = findViewById(R.id.priceEvo);
        priceEvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PriceGraphDialog.showPriceGraph(SolarInfoActivity.this,SolarInfoActivity.this,selectedSolar, solarPrices.get(0).prices);
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
                dataLoad();
            }
        });
    }

    private void priceDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View pricePopupView = getLayoutInflater().inflate(R.layout.price_mod_popup, null);
        dialogBuilder.setView(pricePopupView);

        priceAccept = pricePopupView.findViewById(R.id.priceAccept);
        priceCancel = pricePopupView.findViewById(R.id.priceCancel);

        priceField = (EditText) pricePopupView.findViewById(R.id.priceField);
        priceField.setText(String.valueOf(selectedSolar.price));
        final TextView variation = (TextView) pricePopupView.findViewById(R.id.variation);
        priceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!priceField.getText().toString().equals("") && Integer.valueOf(priceField.getText().toString())!=0) {
                    priceAccept.setEnabled(true);
                    double var = ((Double.valueOf(priceField.getText().toString()) / selectedSolar.price) - 1) * 100;
                    variation.setText(String.format("%.2f", var) + "%");
                    if(var > 0){
                        variation.setTextColor(Color.argb(255,51, 102, 0));
                    } else if(var  == 0){
                        variation.setTextColor(Color.DKGRAY);
                    } else {
                        variation.setTextColor(Color.RED);
                    }
                } else {
                    priceAccept.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        priceAccept.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                db.newPrice(selectedSolar, Integer.valueOf(priceField.getText().toString()));
                alertDialog.cancel();
                dataLoad();
            }
        });

        priceCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
                dataLoad();
            }
        });

        alertDialog = dialogBuilder.create();
        alertDialog.show();


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

    private void dataLoad(){
        final TextView status = findViewById(R.id.status);
        final TextView area = findViewById(R.id.area);
        final TextView price = findViewById(R.id.price);
        status.setText(selectedSolar.status.toUpperCase(Locale.ROOT));
        area.setText(String.format("%d m2",selectedSolar.area));
        price.setText(String.format("%d U$S",selectedSolar.price));
    }
}