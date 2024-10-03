package com.example.moodtrackerapp

import androidx.lifecycle.LiveData
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodEntry
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodEntryDao

class MoodRepository(private val moodEntryDao: MoodEntryDao) {
    val allMoodEntries: LiveData<List<MoodEntry>> = moodEntryDao.getAllMoodEntries()

    suspend fun insert(moodEntry: MoodEntry){
        moodEntryDao.insertMoodEntry(moodEntry)
    }

    suspend fun deleteAll(){
        moodEntryDao.deleteAllMoodEntries()
    }
}