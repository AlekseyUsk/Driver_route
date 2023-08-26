package com.bignerdranch.android.driversroute.room

import androidx.room.*

@Dao
interface RouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoute(routeEntity: RouteEntity)

    @Query("SELECT * FROM route_entity_table")
    fun getRouteAll():List<RouteEntity>

    @Update
    fun updateRoute(historyEntity: RouteEntity)

    @Delete
    fun deleteRoute(historyEntity: RouteEntity)


}