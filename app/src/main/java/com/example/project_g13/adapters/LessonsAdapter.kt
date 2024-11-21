package com.example.project_g13.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_g13.databinding.ItemLessonBinding
import com.example.project_g13.models.Lesson

class LessonsAdapter(
    private val lessons: List<Lesson>,
    private val onLessonClick: (Lesson) -> Unit
) : RecyclerView.Adapter<LessonsAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(val binding: ItemLessonBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.binding.tvLessonName.text = lesson.name
        holder.binding.tvLessonDuration.text = "${lesson.duration} mins"
        holder.binding.root.setOnClickListener { onLessonClick(lesson) }
    }

    override fun getItemCount() = lessons.size
}
