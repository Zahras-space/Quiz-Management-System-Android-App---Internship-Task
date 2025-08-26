package com.example.kotlinapplicationdemo.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.databinding.ActivityLoginBinding
import com.example.kotlinapplicationdemo.model.Authentication
import com.example.kotlinapplicationdemo.view.StudentMainActivity
import com.example.kotlinapplicationdemo.view.TeacherMainActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth = Authentication()
    private var role: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Now it's safe to access intent
        role = intent.getStringExtra("role")

        binding.loginBtn.setOnClickListener {
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            val ok = when (role) {
                "TEACHER" -> auth.teacherVerify(email, password)
                "STUDENT" -> auth.studentVerify(email, password)
                else -> false
            }

            if (ok) {
                val next = if (role == "TEACHER") TeacherMainActivity::class.java else StudentMainActivity::class.java
                startActivity(Intent(this, next))
                finish()
            } else {
                Toast.makeText(this, "Wrong credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
