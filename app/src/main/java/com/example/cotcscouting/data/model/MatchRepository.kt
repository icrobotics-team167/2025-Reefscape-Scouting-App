package com.example.cotcscouting.data.model

import androidx.annotation.WorkerThread
class MatchRepository(private val matchDAO: MatchDAO) {

    val allMatches: List<Match> = matchDAO.getAll()
    @WorkerThread
    fun insert(match: Match) {
        matchDAO.insert(match)
    }
}