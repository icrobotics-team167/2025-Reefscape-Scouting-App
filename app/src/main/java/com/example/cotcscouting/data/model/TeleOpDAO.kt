package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  TeleOpDAO {
    @Query("SELECT * FROM `tele_op`")
    fun getAll(): List<TeleOp>

    @Query("SELECT * FROM `tele_op` WHERE uid IN (:teleOpIds)")
    fun loadAllByIds(teleOpIds: IntArray): List<TeleOp>

    @Query("SELECT * FROM `tele_op` WHERE team_number LIKE :teamNumber LIMIT 1")
    fun findByTeamNumber(teamNumber: Int): TeleOp

    @Insert
    fun insertAll(vararg teleOps: TeleOp)

    @Delete
    fun delete(teleOp: TeleOp)
    @Insert
    fun insert(teleOp: TeleOp)
}