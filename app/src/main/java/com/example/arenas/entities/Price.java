package com.example.arenas.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.util.Date;

@Entity
public class Price {
    @PrimaryKey
    @ColumnInfo(name = "date")
    @NonNull
    public Date date;

    @ColumnInfo(name = "price")
    public int price;

    public int solarId;

    public Price(){

    }

    public Price(Date date, int price){
        this.date = date;
        this.price = price;
    }

}

