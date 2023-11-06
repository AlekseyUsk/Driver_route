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

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :sep")
    fun getSeptember(sep: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :dec")
    fun getDecember(dec: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :apr")
    fun getApril(apr: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :feb")
    fun getFebruary(feb: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :jan")
    fun getJanuary(jan: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :jul")
    fun getJulio(jul: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :june")
    fun getJune(june: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :march")
    fun getMarch(march: String): LiveData<List<RouteEntity>>

    @Query("SELECT * FROM route_entity_table WHERE current_month_route == :may")
    fun getMay(may: String): LiveData<List<RouteEntity>>

    @Update
    suspend fun update(list: List<RouteEntity>)

    @Delete
    suspend fun delete(routeEntity: RouteEntity)

}
//onConflict = OnConflictStrategy.REPLACE в инсерт вставишь
//"SELECT * FROM route_entity_table WHERE current_month_route == :nov" запрос по месяцам
//SELECT * FROM route_entity_table WHERE current_month_route LIKE :nov