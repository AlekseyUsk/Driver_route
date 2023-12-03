package com.bignerdranch.android.driversroute.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RouteEntity::class), version = 4)
abstract class RouteDatabase : RoomDatabase() {
    abstract fun routeDao() : RouteDao
}