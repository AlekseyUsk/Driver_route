package com.bignerdranch.android.driversroute.repository

import androidx.lifecycle.LiveData
import com.bignerdranch.android.driversroute.room.RouteEntity

class Repository() : RepositoryRoom {

    override suspend fun addRoomRoute(list: List<RouteEntity>) {
        super.addRoomRoute(list)
    }

    override suspend fun getRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getRoomRoute()
    }

    override suspend fun getAgostoRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getAgostoRoomRoute()
    }
}