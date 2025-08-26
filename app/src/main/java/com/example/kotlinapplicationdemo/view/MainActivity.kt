package com.example.kotlinapplicationdemo.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import com.example.kotlinapplicationdemo.controller.LoginActivity
import com.example.kotlinapplicationdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


// Student Login button
        binding.studentLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("role", "STUDENT")
            startActivity(intent)
        }

// Teacher Login button
        binding.teacherLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("role", "TEACHER")
            startActivity(intent)
        }

// Exit button
        binding.exitBtn.setOnClickListener {
            finish()
        }
    }
}
