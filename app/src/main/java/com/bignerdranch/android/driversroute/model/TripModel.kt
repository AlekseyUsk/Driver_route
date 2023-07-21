package com.bignerdranch.android.driversroute.model

data class TripModel(
    val date: String,
    val time: String,
    val assistant: String,
    val route: String,
    val em: Int,
    val endOfWork: String,
    val working: String,
    val final: String
)
