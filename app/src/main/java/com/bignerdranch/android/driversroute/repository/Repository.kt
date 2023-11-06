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

    override suspend fun getSeptemberRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getSeptemberRoomRoute()
    }

    override suspend fun getDecemberRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getDecemberRoomRoute()
    }

    override suspend fun getAprilRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getAprilRoomRoute()
    }

    override suspend fun getFebruaryRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getFebruaryRoomRoute()
    }

    override suspend fun getJanuaryRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getJanuaryRoomRoute()
    }

    override suspend fun getJulioRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getJulioRoomRoute()
    }

    override suspend fun getJuneRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getJuneRoomRoute()
    }

    override suspend fun getMarchRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getMarchRoomRoute()
    }

    override suspend fun getMayRoomRoute(): LiveData<List<RouteEntity>> {
        return super.getMayRoomRoute()
    }
}