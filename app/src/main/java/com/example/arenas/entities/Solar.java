package com.example.arenas.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Solar {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "area")
    private int area;
}
