package com.example.project_g13.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_g13.databinding.ActivityLessonsListBinding
import com.example.project_g13.adapters.LessonsAdapter
import com.example.project_g13.models.Lesson
import com.example.project_g13.utils.AppPreferences

class LessonsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonsListBinding
    private lateinit var lessons: List<Lesson>
    private lateinit var completedLessons: MutableList<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lessons = listOf(
            Lesson("Introduction to Android", 10),
            Lesson("Kotlin Basics", 15),
            Lesson("RecyclerView Implementation", 20),
            Lesson("View Bindings in Android", 12),
            Lesson("SharedPreferences Usage", 8)
        )
        completedLessons = AppPreferences.getBooleanList(this, AppPreferences.KEY_COMPLETED_LESSONS, lessons.size)

        val adapter = LessonsAdapter(lessons) { lesson ->
            val intent = Intent(this, LessonDetailsActivity::class.java)
            val lessonIndex = lessons.indexOf(lesson)
            intent.putExtra("lesson", lesson)
            intent.putExtra("lessonIndex", lessonIndex)
            startActivity(intent)
        }
        binding.rvLessons.adapter = adapter
        binding.rvLessons.layoutManager = LinearLayoutManager(this)
    }
}
