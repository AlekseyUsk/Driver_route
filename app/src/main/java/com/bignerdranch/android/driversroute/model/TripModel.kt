package com.bignerdranch.android.driversroute.model

import androidx.lifecycle.LiveData

data class TripModel(
    var date: String,
    var time: String,
    var assistant: String,
    var route: String,
    var em: String,
    var endOfWork: String,
    var working: String,
    var finalHours: String
)
