package com.example.cotcscouting.data.model

import androidx.annotation.WorkerThread

/**
 * Might be borked
 **/
class PitRepository(private val pitDAO: PitDAO) {

    val allPits: List<Pit> = pitDAO.getAll()
    @WorkerThread
    fun insert(pit: Pit) {
        pitDAO.insert(pit)
    }
}