package com.bignerdranch.android.driversroute.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RouteDao {

    @Insert()
   fun insertAll(list: List<RouteEntity>)

   @Insert()
   fun insert(newRouteEntity: RouteEntity)

   @Query("SELECT * FROM route_entity_table")
   fun getAll() : LiveData<List<RouteEntity>>

    @Update
   fun update(routeEntity: RouteEntity)

    @Delete
   fun delete(routeEntity: RouteEntity)

}
//onConflict = OnConflictStrategy.REPLACE в инсерт вставишь