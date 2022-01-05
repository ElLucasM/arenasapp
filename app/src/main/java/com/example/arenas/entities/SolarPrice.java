package com.example.arenas.entities;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

public class SolarPrice {
    @Embedded public Solar solar;
    @Relation(
            parentColumn = "id",
            entityColumn = "solarId"

    )
    public List<Price> prices;

}
