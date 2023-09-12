package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.driversroute.model.TripModel
import com.bignerdranch.android.driversroute.repository.Repository
import com.bignerdranch.android.driversroute.room.RouteEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel() : ViewModel() {

    private val repository = Repository()

    private val mvSdf = SimpleDateFormat("M")
    val mvCurrentDate: String = mvSdf.format(Date())

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
    fun getTripModelRoute(item: TripModel): MutableList<TripModel> {

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

        viewModelScope.launch {
            convertingDataAndSavingItToATable(myList)
        }
        return myList
    }

    //пользователь вводит данные,LiveData наблюдает за изменениями
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

    //region КОНВЕРТЕРЫ

    //конвертирую полученные данные в List<RouteEntity> для передачи в таблицу Room
    private suspend fun convertingDataAndSavingItToATable(list: MutableList<TripModel>) {
        val roomList = mutableListOf<RouteEntity>()
        for (i in myList) {
            val routeEntity = RouteEntity(
                date = i.date,
                time = i.time,
                assistant = i.assistant,
                route = i.route,
                em = i.em,
                endOfWork = i.endOfWork,
                working = i.working, finalHours = i.finalHours
            )
            roomList.add(routeEntity)
            repository.addRoomRoute(roomList)
        }
    }

    //конвертирует данные из Room таблицы /FIX пока незадействовал
    private fun convertToEntity(list: List<RouteEntity>): List<TripModel> {
        val routeTripModel = mutableListOf<TripModel>()
        return list.map {
            val tripModel = TripModel(
                date = it.date,
                time = it.time,
                assistant = it.assistant,
                route = it.route,
                em = it.em,
                endOfWork = it.endOfWork,
                working = it.working, finalHours = it.finalHours
            )
            return routeTripModel
        }
    }

    //endregion
}