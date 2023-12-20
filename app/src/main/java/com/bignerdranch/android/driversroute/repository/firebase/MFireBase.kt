package com.bignerdranch.android.driversroute.repository.firebase

import android.util.Log
import com.bignerdranch.android.driversroute.DATA_BASE_FB
import com.bignerdranch.android.driversroute.model.TripModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MFireBase() {

    private val database = Firebase.database

    fun addFireBaseDataBase(tripModel: TripModel) {
        val dataBaseFireBase = database.getReference(DATA_BASE_FB)
        dataBaseFireBase.push().setValue(tripModel)
    }

    fun onChangeListener(databaseReference: DatabaseReference) {
        //fun для считывания с фаир бейс данных в реальном времени
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("@@@", "ПОЛУЧЕННЫЕ ДАННЫЕ ИЗ FireBase ${snapshot.value.toString()}")
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}

