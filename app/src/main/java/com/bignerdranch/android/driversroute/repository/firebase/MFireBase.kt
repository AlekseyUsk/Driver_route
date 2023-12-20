package com.bignerdranch.android.driversroute.repository.firebase

import com.bignerdranch.android.driversroute.DATA_BASE_FB
import com.bignerdranch.android.driversroute.model.TripModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MFireBase() {

    private val database = Firebase.database

    fun addFireBaseDataBase(tripModel: TripModel) {
        val dataBaseFireBase = database.getReference(DATA_BASE_FB)
        dataBaseFireBase.push().setValue(tripModel)

    }

    fun onChangeListener(databaseReference: DatabaseReference) {
        //    databaseReference.addValueEventListener()
    }
}

