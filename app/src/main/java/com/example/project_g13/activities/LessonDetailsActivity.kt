package com.example.project_g13.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g13.databinding.ActivityLessonDetailsBinding
import com.example.project_g13.models.Lesson
import com.example.project_g13.utils.AppPreferences

class LessonDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonDetailsBinding
    private lateinit var lesson: Lesson
    private lateinit var completedLessons: MutableList<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lesson = intent.getSerializableExtra("lesson") as Lesson
        val lessonIndex = intent.getIntExtra("lessonIndex", -1)
        completedLessons = AppPreferences.getBooleanList(this, AppPreferences.KEY_COMPLETED_LESSONS, 5)

        binding.tvLessonName.text = lesson.name
        binding.tvLessonDuration.text = "Duration: ${lesson.duration} mins"
        binding.tvLessonDescription.text = "This is the description for ${lesson.name}."

        binding.btnWatchLesson.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VIDEO_ID"))
            startActivity(intent)
        }

        binding.btnMarkComplete.setOnClickListener {
            if (lessonIndex != -1) {
                completedLessons[lessonIndex] = true
                AppPreferences.saveBooleanList(this, AppPreferences.KEY_COMPLETED_LESSONS, completedLessons)
                Toast.makeText(this, "Marked as complete!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
