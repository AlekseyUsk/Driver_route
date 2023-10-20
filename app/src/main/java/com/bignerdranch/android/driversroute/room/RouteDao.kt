package com.bignerdranch.android.driversroute.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RouteDao {

    @Insert()
    suspend fun insertAll(routeEntity: RouteEntity)

    @Query("SELECT * FROM route_entity_table")
    fun getAll(): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :ago")
    fun getAgosto(ago: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :okt")
    fun getOctober(okt: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :nov")
    fun getNovember(nov: String): LiveData<List<RouteEntity>>

    @Update
    suspend fun update(list: List<RouteEntity>)

    @Delete
    suspend fun delete(routeEntity: RouteEntity)

}
//onConflict = OnConflictStrategy.REPLACE в инсерт вставишь
//"SELECT * FROM route_entity_table WHERE current_month_route == :nov" запрос по месяцам
//SELECT * FROM route_entity_table WHERE current_month_route LIKE :nov