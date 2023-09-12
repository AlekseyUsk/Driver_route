package com.bignerdranch.android.driversroute.repository

import com.bignerdranch.android.driversroute.room.RouteEntity

interface RepositoryRoom {

   suspend fun addRoomRoute(list: List<RouteEntity>)

   suspend fun getRoomRoute()
}