package com.bignerdranch.android.driversroute.repository

import com.bignerdranch.android.driversroute.MyApp
import com.bignerdranch.android.driversroute.room.RouteEntity

interface RepositoryRoom {

    suspend fun addRoomRoute(routeEntity: RouteEntity) =
        MyApp.getRouteDataBase().routeDao().insertAll(routeEntity)

    suspend fun getRoomRoute() = MyApp.getRouteDataBase().routeDao().getAll()

    suspend fun getAgostoRoomRoute() = MyApp.getRouteDataBase().routeDao().getAgosto("август")

    suspend fun getOctoberRoomRoute() = MyApp.getRouteDataBase().routeDao().getOctober("октябрь")

    suspend fun getNovemberRoomRoute() = MyApp.getRouteDataBase().routeDao().getNovember("ноябрь")

    suspend fun getSeptemberRoomRoute() = MyApp.getRouteDataBase().routeDao().getSeptember("сентябрь")

    suspend fun getDecemberRoomRoute() = MyApp.getRouteDataBase().routeDao().getDecember("декабрь")

    suspend fun getAprilRoomRoute() = MyApp.getRouteDataBase().routeDao().getApril("апрель")

    suspend fun getFebruaryRoomRoute() = MyApp.getRouteDataBase().routeDao().getFebruary("февраль")

    suspend fun getJanuaryRoomRoute() = MyApp.getRouteDataBase().routeDao().getJanuary("январь")

    suspend fun getJulioRoomRoute() = MyApp.getRouteDataBase().routeDao().getJulio("июль")

    suspend fun getJuneRoomRoute() = MyApp.getRouteDataBase().routeDao().getJune("июнь")

    suspend fun getMarchRoomRoute() = MyApp.getRouteDataBase().routeDao().getMarch("март")

    suspend fun getMayRoomRoute() = MyApp.getRouteDataBase().routeDao().getMay("май")

    suspend fun cardDeletion() = MyApp.getRouteDataBase().routeDao().deleteCard("декабрь")


}