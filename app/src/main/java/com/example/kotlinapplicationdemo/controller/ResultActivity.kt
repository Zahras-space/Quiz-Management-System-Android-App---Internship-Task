package com.example.kotlinapplicationdemo.controller
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.databinding.ActivityResultBinding
import com.example.kotlinapplicationdemo.view.StudentMainActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get score from intent
        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        // Display score
        binding.tvScore.text = "Your Score: $score / $total"

        // Retry button -> Restart QuizActivity
        binding.btnRetry.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Finish button -> Go back to StudentMainActivity (or home)
        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, StudentMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
