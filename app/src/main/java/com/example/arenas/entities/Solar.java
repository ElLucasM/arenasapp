package com.example.arenas.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Solar {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "area")
    public int area;

    @ColumnInfo(name = "buy_date")
    public Date buyDate;

    @ColumnInfo(name = "client_name")
    public String clientName;

    @ColumnInfo(name = "client_phone")
    public String clientPhone;

    public Solar(){

    }

    public Solar(int id, String status, int price, int area){
        this.id = id;
        this.status = status;
        this.price = price;
        this.area = area;
    }
}
