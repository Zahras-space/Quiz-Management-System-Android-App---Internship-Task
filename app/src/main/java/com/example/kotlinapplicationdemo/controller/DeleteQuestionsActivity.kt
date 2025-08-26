package com.example.kotlinapplicationdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.data.QuizRepository
import com.example.kotlinapplicationdemo.databinding.ActivityDeleteQuestionBinding

class DeleteQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteQuestionBinding
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load questions from repository
        val questions = QuizRepository.getQuestions()
        val questionTexts = questions.mapIndexed { index, q -> "${index + 1}. ${q.question}" }

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, questionTexts)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.questionSpinner.adapter = adapter

        binding.deleteBtn.setOnClickListener {
            val position = binding.questionSpinner.selectedItemPosition
            if (position != -1 && position < QuizRepository.size()) {
                QuizRepository.deleteQuestion(position)
                Toast.makeText(this, "Question deleted!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "No question selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
