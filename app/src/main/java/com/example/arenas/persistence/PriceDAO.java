package com.example.arenas.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.entities.SolarPrice;

import java.util.Date;
import java.util.List;

@Dao
public interface PriceDAO {
    @Query("SELECT * FROM Solar WHERE id=:id")
    Solar findSolarById(int id);


    @Query("SELECT * FROM Solar")
    List<Solar> getSolares();

    @Query("SELECT * FROM Price")
    List<Price> getPrices();

    @Insert
    public void insertPrecio(Price price);

    @Insert
    void setSolar(Solar solar);


}
