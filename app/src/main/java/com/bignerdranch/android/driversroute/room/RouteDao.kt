package com.bignerdranch.android.driversroute.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RouteDao {

    @Insert()
    suspend fun insertAll(list: List<RouteEntity>)

    @Insert()
    suspend fun insert(newRouteEntity: RouteEntity)

    @Query("SELECT * FROM route_entity_table")
    fun getAll(): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :август")
    fun getAgosto(август: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :октябрь")
    fun getOctober(октябрь: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :ноябрь")
    fun getNovember(ноябрь: String): LiveData<List<RouteEntity>>

    @Update
    suspend fun update(routeEntity: RouteEntity)

    @Delete
    suspend fun delete(routeEntity: RouteEntity)

}
//onConflict = OnConflictStrategy.REPLACE в инсерт вставишь
//"SELECT current_month_route FROM route_entity_table" запрос по месяцам