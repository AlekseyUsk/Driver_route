package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.model.TripModel
import com.bignerdranch.android.driversroute.repository.Repository
import com.bignerdranch.android.driversroute.room.RouteEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

class MainViewModel() : ViewModel() {

    //region Поля
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

    //листы для перегрпировки введыных users данных
    var setList = mutableSetOf<TripModel>()
    var myList = mutableListOf<TripModel>()

//endregion

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
            convertingDataAndSavingItToATable(myList) //запускается конвертер
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

    //конвертируем полученные данные в List<RouteEntity> и передаем в Room
    private suspend fun convertingDataAndSavingItToATable(list: MutableList<TripModel>) {
        val roomDatabaseList = mutableListOf<RouteEntity>()
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
            roomDatabaseList.add(routeEntity)
            repository.addRoomRoute(roomDatabaseList)
        }
    }

    // конвертируем данные из таблицы Room обратно в List<TripModel> и достаем для отображения
    fun convertingSavedDataFromATableToTripModel(list: List<RouteEntity>): MutableList<TripModel> {
        for (i in list) {
            val itemExtractedDataFromRoom = TripModel(
                date = i.date,
                time = i.time,
                assistant = i.assistant,
                route = i.route,
                em = i.em,
                endOfWork = i.endOfWork,
                working = i.working, finalHours = i.finalHours
            )
            setList.add(itemExtractedDataFromRoom)
            myList = setList.toList() as MutableList<TripModel>
        }
        return myList
    }
    //endregion
}
