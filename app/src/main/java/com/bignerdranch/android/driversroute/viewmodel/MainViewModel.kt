package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.driversroute.model.TripModel

class MainViewModel() : ViewModel() {

    var getDate = MutableLiveData<String>("")
    var getTime = MutableLiveData<String>("")
    var getAssistant = MutableLiveData<String>("")
    var getRoute = MutableLiveData<String>("")
    var getEm = MutableLiveData<String>("")
    var getEndOfWork = MutableLiveData<String>("")
    var getWorking = MutableLiveData<String>("")
    var getFinalHours = MutableLiveData<String>("")

    val myLiveData = MutableLiveData<TripModel>()

}