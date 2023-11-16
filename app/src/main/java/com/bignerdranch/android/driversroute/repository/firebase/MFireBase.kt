package com.bignerdranch.android.driversroute.repository.firebase

import com.bignerdranch.android.driversroute.DATA_BASE_FB
import com.bignerdranch.android.driversroute.model.TripModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MFireBase(){

   private var dataBaseFireBase : FirebaseDatabase = FirebaseDatabase.getInstance()

    fun addFireBaseDataBase(tripModel: TripModel) {
        dataBaseFireBase.getReference().push().setValue(tripModel)
        dataBaseFireBase.getReference(DATA_BASE_FB)
    }

    fun initFireBase() {
        dataBaseFireBase.getReference(DATA_BASE_FB)
    }
}