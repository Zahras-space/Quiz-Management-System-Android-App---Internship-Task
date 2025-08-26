package com.example.kotlinapplicationdemo.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.data.QuizRepository
import com.example.kotlinapplicationdemo.model.Question
import com.example.kotlinapplicationdemo.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private var questions: List<Question> = listOf()
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Initialize repository and load questions
        QuizRepository.init()
        questions = QuizRepository.getQuestions()

        // Display first question
        showQuestion()

        // Option A
        binding.btnOptionA.setOnClickListener { checkAnswer("A") }

        // Option B
        binding.btnOptionB.setOnClickListener { checkAnswer("B") }

        // Option C
        binding.btnOptionC.setOnClickListener { checkAnswer("C") }

        // Option D
        binding.btnOptionD.setOnClickListener { checkAnswer("D") }
    }

    private fun showQuestion() {
        if (currentQuestionIndex < questions.size) {
            val q = questions[currentQuestionIndex]
            binding.tvQuestion.text = q.question
            binding.btnOptionA.text = q.options[0]
            binding.btnOptionB.text = q.options[1]
            binding.btnOptionC.text = q.options[2]
            binding.btnOptionD.text = q.options[3]
        } else {
            // Navigate to ResultActivity when quiz ends
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL", questions.size)
            startActivity(intent)
            finish()
        }
    }

    private fun checkAnswer(selectedOption: String) {
        val correctAnswer = questions[currentQuestionIndex].correctAnswer
        if (selectedOption == correctAnswer) {
            score++
        }
        currentQuestionIndex++
        showQuestion()
    }
}
