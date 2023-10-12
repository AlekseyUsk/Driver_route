package com.bignerdranch.android.driversroute.repository

import com.bignerdranch.android.driversroute.MyApp
import com.bignerdranch.android.driversroute.room.RouteEntity

interface RepositoryRoom {

   suspend fun addRoomRoute(list: List<RouteEntity>) = MyApp.getRouteDataBase().routeDao().insertAll(list)

   suspend fun getRoomRoute() = MyApp.getRouteDataBase().routeDao().getAll()

   suspend fun getAgostoRoomRoute() = MyApp.getRouteDataBase().routeDao().getAgosto("август")

   suspend fun getOctoberRoomRoute() = MyApp.getRouteDataBase().routeDao().getOctober("октябрь")

   suspend fun getNovemberRoomRoute() = MyApp.getRouteDataBase().routeDao().getNovember("ноябрь")

   suspend fun getSeptemberRoomRoute() = MyApp.getRouteDataBase().routeDao().getSeptember("сентябрь")

   suspend fun getMayRoomRoute() = MyApp.getRouteDataBase().routeDao().getMay("май")
}