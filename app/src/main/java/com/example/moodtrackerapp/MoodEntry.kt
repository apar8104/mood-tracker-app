package com.example.moodtrackerapp.com.example.moodtrackerapp
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_entry")
data class MoodEntry (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
            val mood: String,
                    val date: Long
)