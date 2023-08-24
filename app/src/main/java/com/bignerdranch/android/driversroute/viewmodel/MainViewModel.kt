package com.bignerdranch.android.driversroute.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.driversroute.model.TripModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel() : ViewModel() {

    private val mvSdf = SimpleDateFormat("M")
    val mvCurrentDate : String = mvSdf.format(Date())

    val getDate = MutableLiveData<String>("")
    val getTime = MutableLiveData<String>("")
    val getAssistant = MutableLiveData<String>("")
    val getRoute = MutableLiveData<String>("")
    val getEm = MutableLiveData<String>("")
    val getEndOfWork = MutableLiveData<String>("")
    val getWorking = MutableLiveData<String>("")
    val getFinalHours = MutableLiveData<String>("")

    val myLiveData = MutableLiveData<TripModel>()

    var setList = mutableSetOf<TripModel>()
    var myList = mutableListOf<TripModel>()

    //введеные данные пользователем обновляют карточку и добавляют ее в список
    fun getTripModelRoute(item: TripModel): List<TripModel>{

        val itemUpdate = TripModel(
            date = item.date,
            time = item.time,
            assistant = item.assistant,
            route = item.route,
            em = item.em,
            endOfWork = item.endOfWork,
            working = item.working,
            finalHours = item.finalHours
        )
        setList.add(itemUpdate)
        myList = setList.toList() as MutableList<TripModel>
        return  myList
    }

    //пользователь вводит данные
    fun setTripModelRoute() {

        val itemStart = TripModel(
            date = "Дата/ ${getDate.value}",
            time = "время явки/ ${getTime.value}",
            assistant = "ТчПМ/ ${getAssistant.value}",
            route = "ПЛЕЧО/ ${getRoute.value}",
            em = "ЭМ/ ${getEm.value}",
            endOfWork = "ОР/ ${getEndOfWork.value}",
            working = "Рабочее время за поездку/ ${getWorking.value}",
            finalHours = "ВСЕГО ЧАСОВ ЗА МЕСЯЦ/ ${getFinalHours.value}"
        )
        myLiveData.value = itemStart
    }

    fun distributionOfDataByMonth(){

    }

}