package com.bignerdranch.android.driversroute

import android.app.Application
import androidx.room.Room
import com.bignerdranch.android.driversroute.repository.room.RouteDatabase

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        myApp = this
    }

    companion object {
        private var myApp: MyApp? = null
        private var routeDatabase: RouteDatabase? = null
        private fun getMyApp() = myApp!!

        fun getRouteDataBase(): RouteDatabase {
            if (routeDatabase == null) {
                routeDatabase = Room.databaseBuilder(
                    getMyApp(), RouteDatabase::class.java, ROOM_DB_NAME_ROUTE
                ).allowMainThreadQueries()
                    .build()  //FIX .allowMainThreadQueries() дает в главном потоке делать запрос надо обойти команду эту
            }
            return routeDatabase!!
        }
        //  val rows = MyApp.getRouteDataBase().routeDao().getRouteAll() строчка код пример вызова базы данных в любом классе
    }
}