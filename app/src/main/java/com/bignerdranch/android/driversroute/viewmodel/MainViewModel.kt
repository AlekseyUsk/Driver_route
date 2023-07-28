package com.bignerdranch.android.driversroute.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.driversroute.model.TripModel

class MainViewModel() : ViewModel() {

    val myLiveData = MutableLiveData<TripModel>()

}