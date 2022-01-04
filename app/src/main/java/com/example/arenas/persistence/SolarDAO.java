package com.example.arenas.persistence;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.arenas.entities.Solar;

@Dao
public interface SolarDAO {
    @Query("SELECT * FROM solar WHERE id=:id")
    Solar findSolarById(int id);
}
