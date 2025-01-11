package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  MatchDAO {
    @Query("SELECT * FROM `match`")
    fun getAll(): List<Match>

    @Query("SELECT * FROM `match` WHERE uid IN (:matchIds)")
    fun loadAllByIds(matchIds: IntArray): List<Match>

    @Query("SELECT * FROM `match` WHERE team_number LIKE :teamNumber LIMIT 1")
    fun findByTeamNumber(teamNumber: Int): Match

    @Insert
    fun insertAll(vararg matches: Match)

    @Delete
    fun delete(match: Match)
    @Insert
    fun insert(match: Match)
}