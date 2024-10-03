package com.example.moodtrackerapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodEntry

class MainActivity : AppCompatActivity() {

    private val moodViewModel: MoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adjust insets (optional for edge-to-edge layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup RecyclerView
        val adapter = MoodAdapter() // Use correct class name with uppercase 'M'
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) // Use findViewById
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe LiveData from ViewModel and update RecyclerView
        moodViewModel.allMoodEntries.observe(this, Observer { moodEntries ->
            moodEntries?.let { adapter.submitList(it) }
        })

        // Setup button for adding mood entries
        val buttonAddMood = findViewById<Button>(R.id.button_add_mood)
        buttonAddMood.setOnClickListener {
            val newMoodEntry = MoodEntry(mood = "Happy", date = System.currentTimeMillis())
            moodViewModel.insert(newMoodEntry)
        }
    }
}
