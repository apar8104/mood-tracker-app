package com.example.moodtrackerapp.com.example.moodtrackerapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoodEntryDao {

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertMoodEntry(moodEntry: MoodEntry)

    @Query("SELECT * FROM mood_entry ORDER BY date DESC")
    fun getAllMoodEntries(): LiveData<List<MoodEntry>>

    @Query("DELETE FROM mood_entry")
    suspend fun deleteAllMoodEntries()
}
