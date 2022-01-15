package com.example.arenas.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(primaryKeys = {"date", "solarId"})
public class Price {
    @ColumnInfo(name = "date")
    @NonNull
    public LocalDateTime date;

    @ColumnInfo(name = "price")
    public int price;

    public int solarId;

    public Price(){

    }

    public Price(LocalDateTime date, int price){
        this.date = date;
        this.price = price;
    }

    @NonNull
    public LocalDateTime getDate() {
        return date;
    }
}

