package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
* I just copied and pasted AllianceDAO and renamed stuff to pit stuff. This could be completely borked (Thank you Tada for teaching me that word) idk.
* */
@Dao
interface PitDAO {
    @Query("SELECT * FROM `pit`")
    fun getAll(): List<Pit>

    @Query("SELECT * FROM 'pit' WHERE uid IN (:pitIds)")
    fun loadAllByIds(pitIds: IntArray): List<Pit>

    @Query("SELECT * FROM `pit` WHERE team_number LIKE :teamNumber LIMIT 1")
    fun findByTeamNumber(teamNumber: Int): Pit

    @Insert
    fun insertAll(vararg pits: Pit)

    @Delete
    fun delete(pit: Pit)

    @Insert
    abstract fun insert(pit: Pit)
}