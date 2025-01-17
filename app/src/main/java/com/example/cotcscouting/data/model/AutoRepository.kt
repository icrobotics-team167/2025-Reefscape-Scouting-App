package com.example.cotcscouting.data.model

import androidx.annotation.WorkerThread
class AutoRepository(private val autoDAO: AutoDAO) {

    val allAutos: List<Auto> = autoDAO.getAll()
    @WorkerThread
    fun insert(auto: Auto) {
        autoDAO.insert(auto)
    }
}