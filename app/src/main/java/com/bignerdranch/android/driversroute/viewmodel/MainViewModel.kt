package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.driversroute.model.TripModel
import com.bignerdranch.android.driversroute.repository.Repository
import com.bignerdranch.android.driversroute.room.RouteEntity
import com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear.JanuaryFragment
import com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear.NovemberFragment
import com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear.OctoberFragment
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

class MainViewModel() : ViewModel() {

    //region Поля
    private val repository = Repository()

    private val mvSdf = SimpleDateFormat("M")
    val mvCurrentDate: String = mvSdf.format(Date())

    val getMonth = MutableLiveData<String>("")
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
    var convertedRoomDataSheetToTripModel= mutableListOf<TripModel>()

//endregion

    //пользователь ввел данные,в setTripModelRoute()->LiveData наблюдает за изменениями и
    //введеные данные пользователем обновляют карточку и добавляют ее в список
    fun writeANewCard(item: TripModel): MutableList<TripModel> {
        val itemUpdate = TripModel(
            date = item.date,
            time = item.time,
            assistant = item.assistant,
            route = item.route,
            em = item.em,
            endOfWork = item.endOfWork,
            working = item.working,
            finalHours = item.finalHours,
            turnoutMonth = item.turnoutMonth
        )
        setList.add(itemUpdate)
        myList = setList.toList() as MutableList<TripModel>

        viewModelScope.launch {
            convertingDataAndSavingItToATable(myList) //запускается конвертер
        }
        return myList
    }

//    fun save(list: MutableList<TripModel>){
//                viewModelScope.launch {
//            convertingDataAndSavingItToATable(myList) //запускается конвертер
//        }
//    }

    //пользователь вводит данные,LiveData наблюдает за изменениями
    fun setTripModelRoute() {
        val itemStart = TripModel(
            date = "${getDate.value}",
            time = "время явки/ ${getTime.value}",
            assistant = "ТчПМ/ ${getAssistant.value}",
            route = "ПЛЕЧО/ ${getRoute.value}",
            em = "ЭМ/ ${getEm.value}",
            endOfWork = "ОР/ ${getEndOfWork.value}",
            working = "Рабочее время за поездку/ ${getWorking.value}",
            finalHours = "ВСЕГО ЧАСОВ ЗА МЕСЯЦ/ ${getFinalHours.value}",
            turnoutMonth = "${getMonth.value}"
        )
        myLiveData.value = itemStart
    }

    //region КОНВЕРТЕРЫ

    //конвертируем полученные данные в List<RouteEntity> и передаем в Room
    private suspend fun convertingDataAndSavingItToATable(list: MutableList<TripModel>) {
        for (i in myList) {
            val routeEntity = RouteEntity(
                date = i.date,
                time = i.time,
                assistant = i.assistant,
                route = i.route,
                em = i.em,
                endOfWork = i.endOfWork,
                working = i.working,
                finalHours = i.finalHours,
                currentMonth = i.turnoutMonth
            )
            repository.addRoomRoute(routeEntity)
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
                working = i.working,
                finalHours = i.finalHours,
                turnoutMonth = i.currentMonth
            )
            setList.add(itemExtractedDataFromRoom)
            convertedRoomDataSheetToTripModel = setList.toList() as MutableList<TripModel>
        }
        return convertedRoomDataSheetToTripModel
    }
    //endregion
}
