package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.driversroute.model.TripModel

class MainViewModel() : ViewModel() {

    private val _dateOfAppearance = MutableLiveData<String>()// пока заготовка исп ипотом
    val dateOfAppearance: LiveData<String>
        get() = _dateOfAppearance

    val myLiveData = MutableLiveData<TripModel>()

    fun getTripModelRoute(item: TripModel): List<TripModel> {
        val list = arrayListOf<TripModel>()

        val item = TripModel(
            date = item.date,
            time = item.time,
            assistant = item.assistant,
            route = item.route,
            em = item.em,
            endOfWork = item.endOfWork,
            working = item.working,
            final_hours = item.final_hours
        )
        list.add(item)
        return list
    }

    fun setTripModelRoute(dateStr: String) {
        val item = TripModel(
            date = "",
            time = "dddddd",
            assistant = "",
            route = "",
            em = "",
            endOfWork = "",
            working = "",
            final_hours = ""
        )
        myLiveData.value = item
    }

}