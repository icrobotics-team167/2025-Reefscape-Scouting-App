package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  EndGameDAO {
    @Query("SELECT * FROM `end_game`")
    fun getAll(): List<EndGame>

    @Query("SELECT * FROM `end_game` WHERE uid IN (:endGameIds)")
    fun loadAllByIds(endGameIds: IntArray): List<EndGame>

    @Query("SELECT * FROM `end_game` WHERE team_number LIKE :teamNumber LIMIT 1")
    fun findByTeamNumber(teamNumber: Int): EndGame

    @Insert
    fun insertAll(vararg endGames: EndGame)

    @Delete
    fun delete(endGame: EndGame)
    @Insert
    fun insert(endGame: EndGame)
}