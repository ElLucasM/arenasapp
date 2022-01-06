package com.example.arenas.persistence;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Transaction;
import androidx.room.TypeConverters;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.entities.SolarPrice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@Database(entities = {Solar.class, Price.class}, version = 7)
@TypeConverters({Converters.class})
public abstract class ArenasDatabase extends RoomDatabase {
    public abstract SolarDAO solarDAO();
    public abstract PriceDAO priceDAO();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Transaction
    public void insertSolar(int id, String status, int price, int area){
        Solar solar = new Solar(id, status, price, area);
        Price newPrice = new Price(Date.from(Instant.now()),price);
        newPrice.solarId = id;
        solarDAO().insertSolar(solar);
        priceDAO().insertPrecio(newPrice);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Transaction
    public void newPrice(Solar solar, int price){
        Price newPrice = new Price(Date.from(Instant.now()),price);
        solar.price = newPrice.price;
        newPrice.solarId = solar.id;
        priceDAO().insertPrecio(newPrice);
        solarDAO().updateSolar(solar);


    }
}
