package com.bignerdranch.android.driversroute.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "route_entity_table")
data class RouteEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "date_route")
    var date: String,
    @ColumnInfo(name = "time_route")
    var time: String,
    @ColumnInfo(name = "assistant_route")
    var assistant: String,
    @ColumnInfo(name = "route")
    var route: String,
    @ColumnInfo(name = "em_route")
    var em: String,
    @ColumnInfo(name = "endOfWor_route")
    var endOfWork: String,
    @ColumnInfo(name = "working_route")
    var working: String,
    @ColumnInfo(name = "finalHours_route")
    var finalHours: String
)
