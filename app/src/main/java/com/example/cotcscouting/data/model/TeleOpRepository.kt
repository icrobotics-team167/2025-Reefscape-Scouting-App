package com.example.cotcscouting.data.model

import androidx.annotation.WorkerThread
class TeleOpRepository(private val teleOpDAO: TeleOpDAO) {

    val allTeleOps: List<TeleOp> = teleOpDAO.getAll()
    @WorkerThread
    fun insert(teleOp: TeleOp) {
        teleOpDAO.insert(teleOp)
    }
}