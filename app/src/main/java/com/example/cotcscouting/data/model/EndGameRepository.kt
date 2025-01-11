package com.example.cotcscouting.data.model

import androidx.annotation.WorkerThread
class EndGameRepository(private val endGameDAO: EndGameDAO) {

    val allEndGames: List<EndGame> = endGameDAO.getAll()
    @WorkerThread
    fun insert(endGame: EndGame) {
        endGameDAO.insert(endGame)
    }
}