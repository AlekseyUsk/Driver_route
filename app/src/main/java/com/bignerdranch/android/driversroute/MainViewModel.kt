package com.bignerdranch.android.driversroute

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val liveDataCurrent = MutableLiveData<String>() // основное окошко
    val liveDataList = MutableLiveData<String>()    // список поездок

}