package com.example.project_g13.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g13.databinding.ActivityEnterNameBinding
import com.example.project_g13.utils.AppPreferences

class EnterNameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotEmpty()) {
                AppPreferences.saveString(this, AppPreferences.KEY_USER_NAME, name)
                startActivity(Intent(this, LessonsListActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
