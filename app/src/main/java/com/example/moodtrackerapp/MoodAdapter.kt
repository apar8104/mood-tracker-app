package com.example.moodtrackerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtrackerapp.com.example.moodtrackerapp.MoodEntry

class MoodAdapter : RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

    private var moodEntries = emptyList<MoodEntry>()

    class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val moodTextView: TextView = itemView.findViewById(R.id.moodTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mood_entry, parent, false)
        return MoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val currentMood = moodEntries[position]
        holder.moodTextView.text = currentMood.mood
        holder.dateTextView.text = android.text.format.DateFormat.format("yyyy-MM-dd", currentMood.date)
    }

    override fun getItemCount(): Int {
        return moodEntries.size
    }

    fun submitList(moods: List<MoodEntry>) {
        moodEntries = moods
        notifyDataSetChanged()
    }
}
