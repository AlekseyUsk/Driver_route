package com.bignerdranch.android.driversroute.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RouteEntity::class), version = 2)
abstract class RouteDatabase : RoomDatabase() {
    abstract fun routeDao() : RouteDao
}