package com.example.arenas.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Solar {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "area")
    public int area;
}
