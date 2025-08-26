package com.example.kotlinapplicationdemo.view
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.controller.*
import com.example.kotlinapplicationdemo.databinding.ActivityStudentBinding

class StudentMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playQuizBtn.setOnClickListener {
                val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
// Exit button
        binding.exitBtn.setOnClickListener {
            finish()
        }
    }
}
