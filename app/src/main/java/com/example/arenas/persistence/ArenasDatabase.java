package com.example.arenas.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.arenas.entities.Solar;

@Database(entities = {Solar.class},version = 1)
public abstract class ArenasDatabase extends RoomDatabase {
    public abstract SolarDAO solarDAO();
}
