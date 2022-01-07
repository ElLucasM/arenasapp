package com.example.arenas.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.arenas.entities.Price;
import com.example.arenas.entities.Solar;
import com.example.arenas.entities.SolarPrice;

import java.util.List;

@Dao
public interface SolarDAO {
    @Query("SELECT * FROM Solar WHERE id=:id")
    Solar findSolarById(int id);

    @Query("SELECT * FROM Solar ORDER BY id asc")
    List<Solar> getAllSolares();

    @Insert
    void insertSolar(Solar solar);

    @Insert
    void newPrice(Price price);

    @Transaction
    @Query("select * from Solar where id=:id")
    List<SolarPrice> getPrices(int id);

    @Update
    void updateSolar(Solar solar);

}
