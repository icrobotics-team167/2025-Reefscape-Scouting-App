package com.example.cotcscouting.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Match::class, Alliance::class, Pit::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDAO(): MatchDAO
    abstract fun allianceDAO(): AllianceDAO
    abstract fun pitDAO(): PitDAO // Talk to Madison about PitDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "scouting"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}


