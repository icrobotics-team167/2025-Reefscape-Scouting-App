package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alliance")
data class Alliance(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "blue_notes") var blueNotes: String,
    @ColumnInfo(name = "blue_amp_count") var blueAmpCount: Int,
    @ColumnInfo(name = "blue_co_op") var blueCoOp: Boolean,
    @ColumnInfo(name = "blue_melody") var blueMelody: Boolean,
    @ColumnInfo(name = "blue_ensamble") var blueEnsamble: Boolean,
    @ColumnInfo(name = "blue_harmony") var blueHarmony: Boolean,
    @ColumnInfo(name = "red_notes") var redNotes: String,
    @ColumnInfo(name = "red_amp_count") var redAmpCount: Int,
    @ColumnInfo(name = "red_co_op") var redCoOp: Boolean,
    @ColumnInfo(name = "red_melody") var redMelody: Boolean,
    @ColumnInfo(name = "red_ensamble") var redEnsamble: Boolean,
    @ColumnInfo(name = "red_harmony") var redHarmony: Boolean,
    @ColumnInfo(name = "match_number") var matchNumber: Int,
    @ColumnInfo(name = "scout_name") var scoutName: String,
    @ColumnInfo(name= "regional_code") var regionalCode: String,
    @ColumnInfo(name= "michael_red_1") var michaelRed1: String,
    @ColumnInfo(name= "michael_red_2") var michaelRed2: String,
    @ColumnInfo(name= "michael_red_3") var michaelRed3: String,
    @ColumnInfo(name= "michael_blue_1") var michaelBlue1: String,
    @ColumnInfo(name= "michael_blue_2") var michaelBlue2: String,
    @ColumnInfo(name= "michael_blue_3") var michaelBlue3: String


)
