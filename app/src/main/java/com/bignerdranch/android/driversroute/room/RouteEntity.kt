package com.bignerdranch.android.driversroute.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "route_entity_table")
data class RouteEntity(

    @PrimaryKey(autoGenerate = true)
    var date: String,
    var time: String,
    var assistant: String,
    var route: String,
    var em: String,
    var endOfWork: String,
    var working: String,
    var finalHours: String
)
