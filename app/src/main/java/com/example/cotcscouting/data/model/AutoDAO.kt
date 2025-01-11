package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  AutoDAO {
    @Query("SELECT * FROM `auto`")
    fun getAll(): List<Auto>

    @Query("SELECT * FROM `auto` WHERE uid IN (:autoIds)")
    fun loadAllByIds(autoIds: IntArray): List<Auto>

    @Query("SELECT * FROM `auto` WHERE team_number LIKE :teamNumber LIMIT 1")
    fun findByTeamNumber(teamNumber: Int): Auto

    @Insert
    fun insertAll(vararg autoes: Auto)

    @Delete
    fun delete(auto: Auto)
    @Insert
    fun insert(auto: Auto)
}