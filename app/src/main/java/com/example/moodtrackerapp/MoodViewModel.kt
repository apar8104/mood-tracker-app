package com.example.moodtrackerapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodDatabase
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodEntry
import kotlinx.coroutines.launch

class MoodViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MoodRepository
    val allMoodEntries: LiveData<List<MoodEntry>>

    init{
        val moodEntryDao = MoodDatabase.getDatabase(application).moodEntryDao()
        repository = MoodRepository(moodEntryDao)
        allMoodEntries = repository.allMoodEntries
    }

    fun insert(moodEntry: MoodEntry) = viewModelScope.launch {
        repository.insert(moodEntry)
    }

    fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }
}