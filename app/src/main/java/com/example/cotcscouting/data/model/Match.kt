package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match")
data class Match(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "auto_amp_count") var autoAmpCount: Int,
    @ColumnInfo(name = "auto_speaker_count") var autoSpeakerCount: Int,
    @ColumnInfo(name = "teleop_amp_count") var teleopAmpCount: Int,
    @ColumnInfo(name = "tele_op_speaker_count") var teleOpSpeakerCount: Int,
    @ColumnInfo(name = "leave") var leave: Boolean,
    @ColumnInfo(name = "on_stage") var onStage: Boolean,
    @ColumnInfo(name = "on_stage_spotlit") var onStageSpotlit: Boolean,
    @ColumnInfo(name = "trap_note") var trapNote: Int,
    @ColumnInfo(name = "park") var park: Boolean,
    @ColumnInfo(name = "defense") var defense: Boolean,
    @ColumnInfo(name = "disabled_robot") var disabledRobot: Boolean,
    @ColumnInfo(name = "shooting_distance_bar") var shootingDistanceBar: Int,
    @ColumnInfo(name = "match_number") var matchNumber: String,
    @ColumnInfo(name = "match_notes") var matchNotes: String,
    @ColumnInfo(name = "team_number") var teamNumber: String,
    @ColumnInfo(name = "scout_name") var scoutName: String,
    @ColumnInfo(name= "regional_code") var regionalCode: String
)
