package com.bignerdranch.android.driversroute.repository

import androidx.lifecycle.LiveData
import com.bignerdranch.android.driversroute.room.RouteEntity

class Repository() : RepositoryRoom {
    override suspend fun addRoomRoute(routeEntity: RouteEntity) {
        super.addRoomRoute(routeEntity)
    }
    override suspend fun getRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getRoomRoute()
    }

    override suspend fun getAgostoRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getAgostoRoomRoute()
    }

    override suspend fun getOctoberRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getOctoberRoomRoute()
    }

    override suspend fun getNovemberRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getNovemberRoomRoute()
    }
}