package com.example.project_g13.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g13.databinding.ActivityWelcomeBackBinding
import com.example.project_g13.utils.AppPreferences

class WelcomeBackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = AppPreferences.getString(this, AppPreferences.KEY_USER_NAME) ?: ""
        binding.tvWelcome.text = "Welcome back, $name!"

        binding.btnLessons.setOnClickListener {
            startActivity(Intent(this, LessonsListActivity::class.java))
        }

        binding.btnReset.setOnClickListener {
            AppPreferences.saveString(this, AppPreferences.KEY_USER_NAME, "")
            AppPreferences.saveBooleanList(this, AppPreferences.KEY_COMPLETED_LESSONS, emptyList())
            startActivity(Intent(this, EnterNameActivity::class.java))
            finish()
        }
    }
}
