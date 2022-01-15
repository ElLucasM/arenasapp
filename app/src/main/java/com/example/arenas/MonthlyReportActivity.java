package com.example.arenas;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.anychart.chart.common.dataentry.DataEntry;
import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.persistence.ArenasDatabase;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MonthlyReportActivity extends AppCompatActivity {

    public static Month month;
    public static int year;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_report);

        TextView[] stateLabels = new TextView[22];
        TextView[] solarLabels = new TextView[22];
        TextView[] priceLabels = new TextView[22];

        {
            stateLabels[0] = findViewById(R.id.solarRepState);
            stateLabels[1] = findViewById(R.id.solarRepState2);
            stateLabels[2] = findViewById(R.id.solarRepState3);
            stateLabels[3] = findViewById(R.id.solarRepState4);
            stateLabels[4] = findViewById(R.id.solarRepState5);
            stateLabels[5] = findViewById(R.id.solarRepState6);
            stateLabels[6] = findViewById(R.id.solarRepState7);
            stateLabels[7] = findViewById(R.id.solarRepState8);
            stateLabels[8] = findViewById(R.id.solarRepState9);
            stateLabels[9] = findViewById(R.id.solarRepState10);
            stateLabels[10] = findViewById(R.id.solarRepState11);
            stateLabels[11] = findViewById(R.id.solarRepState12);
            stateLabels[12] = findViewById(R.id.solarRepState13);
            stateLabels[13] = findViewById(R.id.solarRepState14);
            stateLabels[14] = findViewById(R.id.solarRepState15);
            stateLabels[15] = findViewById(R.id.solarRepState16);
            stateLabels[16] = findViewById(R.id.solarRepState17);
            stateLabels[17] = findViewById(R.id.solarRepState18);
            stateLabels[18] = findViewById(R.id.solarRepState19);
            stateLabels[19] = findViewById(R.id.solarRepState20);
            stateLabels[20] = findViewById(R.id.solarRepState21);
            stateLabels[21] = findViewById(R.id.solarRepState22);

            priceLabels[0] = findViewById(R.id.solarPriceRep);
            priceLabels[1] = findViewById(R.id.solarPriceRep2);
            priceLabels[2] = findViewById(R.id.solarPriceRep3);
            priceLabels[3] = findViewById(R.id.solarPriceRep4);
            priceLabels[4] = findViewById(R.id.solarPriceRep5);
            priceLabels[5] = findViewById(R.id.solarPriceRep6);
            priceLabels[6] = findViewById(R.id.solarPriceRep7);
            priceLabels[7] = findViewById(R.id.solarPriceRep8);
            priceLabels[8] = findViewById(R.id.solarPriceRep9);
            priceLabels[9] = findViewById(R.id.solarPriceRep10);
            priceLabels[10] = findViewById(R.id.solarPriceRep11);
            priceLabels[11] = findViewById(R.id.solarPriceRep12);
            priceLabels[12] = findViewById(R.id.solarPriceRep13);
            priceLabels[13] = findViewById(R.id.solarPriceRep14);
            priceLabels[14] = findViewById(R.id.solarPriceRep15);
            priceLabels[15] = findViewById(R.id.solarPriceRep16);
            priceLabels[16] = findViewById(R.id.solarPriceRep17);
            priceLabels[17] = findViewById(R.id.solarPriceRep18);
            priceLabels[18] = findViewById(R.id.solarPriceRep19);
            priceLabels[19] = findViewById(R.id.solarPriceRep20);
            priceLabels[20] = findViewById(R.id.solarPriceRep21);
            priceLabels[21] = findViewById(R.id.solarPriceRep22);

            solarLabels[0] = findViewById(R.id.si);
            solarLabels[1] = findViewById(R.id.si2);
            solarLabels[2] = findViewById(R.id.si3);
            solarLabels[3] = findViewById(R.id.si4);
            solarLabels[4] = findViewById(R.id.si5);
            solarLabels[5] = findViewById(R.id.si6);
            solarLabels[6] = findViewById(R.id.si7);
            solarLabels[7] = findViewById(R.id.si8);
            solarLabels[8] = findViewById(R.id.si9);
            solarLabels[9] = findViewById(R.id.si10);
            solarLabels[10] = findViewById(R.id.si11);
            solarLabels[11] = findViewById(R.id.si12);
            solarLabels[12] = findViewById(R.id.si13);
            solarLabels[13] = findViewById(R.id.si14);
            solarLabels[14] = findViewById(R.id.si15);
            solarLabels[15] = findViewById(R.id.si16);
            solarLabels[16] = findViewById(R.id.si17);
            solarLabels[17] = findViewById(R.id.si18);
            solarLabels[18] = findViewById(R.id.si19);
            solarLabels[19] = findViewById(R.id.si20);
            solarLabels[20] = findViewById(R.id.si21);
            solarLabels[21] = findViewById(R.id.si22);
        }

        ArenasDatabase db = Room.databaseBuilder(getApplicationContext(), ArenasDatabase.class, "arenasdb").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        List<Solar> solares = db.solarDAO().getAllSolares();

        for (int i = 0; i < 22; i++) {
            Solar solar = solares.get(i);
            switch (solar.status) {
                case "libre":
                    stateLabels[i].setTextColor(Color.GREEN);
                    stateLabels[i].setText("LIBRE");
                    break;
                case "reservado":
                    if(month.getValue()>9) {
                        if (solar.buyDate.before(Date.from(Instant.parse(String.format("%d-%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year))))))) {
                            stateLabels[i].setTextColor(Color.rgb(216, 128, 16));
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    } else {
                        Date date = Date.from(Instant.parse(String.format("%d-0%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year)))));
                        if (solar.buyDate.before(date)){
                            stateLabels[i].setTextColor(Color.rgb(216, 128, 16));
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    }
                    break;
                case "comprado":
                    if(month.getValue()>9) {
                        if (solar.buyDate.before(Date.from(Instant.parse(String.format("%d-%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year))))))) {
                            stateLabels[i].setTextColor(Color.RED);
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    } else {
                        if (solar.buyDate.before(Date.from(Instant.parse(String.format("%d-0%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year))))))) {
                            stateLabels[i].setTextColor(Color.RED);
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    }
                    break;
                case "construido":
                    if(month.getValue()>9) {
                        if (solar.buyDate.before(Date.from(Instant.parse(String.format("%d-%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year))))))) {
                            stateLabels[i].setTextColor(Color.BLUE);
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    }else {
                        if (solar.buyDate.before(Date.from(Instant.parse(String.format("%d-0%d-%dT23:59:59.000Z", year, month.getValue(), month.length(Year.isLeap(year))))))) {
                            stateLabels[i].setTextColor(Color.BLUE);
                            stateLabels[i].setText(solar.status.toUpperCase());
                        } else {
                            stateLabels[i].setTextColor(Color.GREEN);
                            stateLabels[i].setText("LIBRE");
                        }
                    }
                    break;
            }
            List<Price> prices = db.solarDAO().getPrices(solar.id).get(0).prices;
            List<Price> thisMonth = new ArrayList<>();
            List<Price> lastMonth = new ArrayList<>();
            if(prices.size()>1) {
                for (Price price : prices) {
                    if (price.date.getMonth().equals(month) && price.date.getYear() == year) {
                        thisMonth.add(price);
                    } else if (price.date.getMonth().equals(month.minus(1))) {
                        if (month.getValue() == 1 && year - 1 == price.date.getYear()) {
                            lastMonth.add(price);
                        } else if (year == price.date.getYear()) {
                            lastMonth.add(price);
                        }
                    }
                }

                if(thisMonth.size()>0 && lastMonth.size()>0) {

                    int thisPrice = thisMonth.stream().max(Comparator.comparing(Price::getDate)).get().price;
                    int lastPrice = lastMonth.stream().max(Comparator.comparing(Price::getDate)).get().price;
                    priceLabels[i].setText(String.format("$ %d (%d", solar.price, 100 * thisPrice / lastPrice - 100) + "%)");
                } else if(lastMonth.size() == 0 && thisMonth.size()>0) {
                    Price lastPrice = null;
                    int thisPrice = thisMonth.stream().max(Comparator.comparing(Price::getDate)).get().price;
                    for(Price price: prices){
                        if(price.date.isBefore(LocalDateTime.of(year,month.getValue(),1,0,0))
                        && lastPrice == null) {
                            lastPrice = price;
                        } else if(lastPrice != null && price.date.getMonth().equals(lastPrice.getDate().getMonth())){
                            lastPrice = price;
                        }
                    }
                    if(lastPrice != null){
                        priceLabels[i].setText(String.format("$ %d (%d%%)", thisPrice, 100*thisPrice/lastPrice.price - 100));
                    } else {
                        priceLabels[i].setText(String.format("$ %d", thisMonth.stream().max(Comparator.comparing(Price::getDate)).get().price) + " (0%)");
                    }
                } else if(thisMonth.size() == 0){
                    for(Price price: prices){
                        if(price.date.isBefore(LocalDateTime.of(year,month.getValue(),1,0,0))) {
                            int lastPrice = lastMonth.stream().max(Comparator.comparing(Price::getDate)).get().price;
                            priceLabels[i].setText(String.format("$ %d", lastPrice) + " (0%)");
                            break;
                        } else {
                            priceLabels[i].setText(String.format("$ %d", solar.price) + " (0%)");
                        }
                    }
                }
            } else {
                priceLabels[i].setText(String.format("$ %d", solar.price) + " (0%)");
            }
        }
    }
}
