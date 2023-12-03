package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.driversroute.model.TripModel
import com.bignerdranch.android.driversroute.repository.firebase.MFireBase
import com.bignerdranch.android.driversroute.repository.room.Repository
import com.bignerdranch.android.driversroute.repository.room.RouteEntity
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel() : ViewModel() {

    //region Поля
    private val repository = Repository()
    private var mFireBase = MFireBase()

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

    //листы для перегрпировки введыных users данных с отсеиванием дубликатов
    private var setList = mutableSetOf<TripModel>()
    var myList = mutableListOf<TripModel>()

    private var setListAgosto = mutableSetOf<TripModel>()
    private var listAgosto = mutableListOf<TripModel>()

    private var setListSeptember = mutableSetOf<TripModel>()
    private var listSeptember = mutableListOf<TripModel>()

    private var setListNovember = mutableSetOf<TripModel>()
    private var listNovember = mutableListOf<TripModel>()

    private var setListApril = mutableSetOf<TripModel>()
    private var listApril = mutableListOf<TripModel>()

    private var setListDecember = mutableSetOf<TripModel>()
    private var listDecember = mutableListOf<TripModel>()

    private var setListFebruary = mutableSetOf<TripModel>()
    private var listFebruary = mutableListOf<TripModel>()

    private var setListJanuary = mutableSetOf<TripModel>()
    private var listJanuary = mutableListOf<TripModel>()

    private var setListJulio = mutableSetOf<TripModel>()
    private var listJulio = mutableListOf<TripModel>()

    private var setListJune = mutableSetOf<TripModel>()
    private var listJune = mutableListOf<TripModel>()

    private var setListMarch = mutableSetOf<TripModel>()
    private var listMarch = mutableListOf<TripModel>()

    private var setListMay = mutableSetOf<TripModel>()
    private var listMay = mutableListOf<TripModel>()

    private var setListOctober = mutableSetOf<TripModel>()
    private var listOctober = mutableListOf<TripModel>()

//endregion

    //отправка в FireBase
    private fun sendInFairBase(tripModel: TripModel){
        mFireBase.addFireBaseDataBase(tripModel)
    }

    /**пользователь ввел данные,в setTripModelRoute()->LiveData наблюдает за изменениями и
    введеные данные пользователем обновляют карточку и добавляют ее в список */
    fun writeANewCard(item: TripModel) {
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
            convertingDataAndSavingItToATable(myList) //запускается конвертер для переделывания данных и помещает их в Room
        }
    }

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
        sendInFairBase(itemStart)
    }

    //region КОНВЕРТЕРЫ

    //конвертируем полученные данные RouteEntity и передаем в Room
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

    // конвертируем данные из таблицы Room обратно в List<TripModel> по месяцам и передаем адаптеру результат
    fun convertingSeptember(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListSeptember.add(it)
                listSeptember = setListSeptember.toList() as MutableList<TripModel>
            }
        }
        return listSeptember
    }

    fun convertingAgosto(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListAgosto.add(it)
                listAgosto = setListAgosto.toList() as MutableList<TripModel>
            }
        }
        return listAgosto
    }

    fun convertingNovember(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListNovember.add(it)
                listNovember = setListNovember.toList() as MutableList<TripModel>
            }
        }
        return listNovember
    }

    fun convertingApril(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListApril.add(it)
                listApril = setListApril.toList() as MutableList<TripModel>
            }
        }
        return listApril
    }

    fun convertingDecember(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListDecember.add(it)
                listDecember = setListDecember.toList() as MutableList<TripModel>
            }
        }
        return listDecember
    }

    fun convertingFebruary(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListFebruary.add(it)
                listFebruary = setListFebruary.toList() as MutableList<TripModel>
            }
        }
        return listFebruary
    }

    fun convertingJanuary(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListJanuary.add(it)
                listJanuary = setListJanuary.toList() as MutableList<TripModel>
            }
        }
        return listJanuary
    }

    fun convertingJulio(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListJulio.add(it)
                listJulio = setListJulio.toList() as MutableList<TripModel>
            }
        }
        return listJulio
    }

    fun convertingJune(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListJune.add(it)
                listJune = setListJune.toList() as MutableList<TripModel>
            }
        }
        return listJune
    }

    fun convertingMarch(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListMarch.add(it)
                listMarch = setListMarch.toList() as MutableList<TripModel>
            }
        }
        return listMarch
    }

    fun convertingMay(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListMay.add(it)
                listMay = setListMay.toList() as MutableList<TripModel>
            }
        }
        return listMay
    }

    fun convertingOctober(list: List<RouteEntity>): List<TripModel> {
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
            ).let {
                setListOctober.add(it)
                listOctober = setListOctober.toList() as MutableList<TripModel>
            }
        }
        return listOctober
    }

    //endregion
}




