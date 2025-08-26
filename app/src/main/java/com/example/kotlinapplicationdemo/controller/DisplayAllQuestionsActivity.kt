package com.example.kotlinapplicationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapplicationdemo.controller.QuestionsAdapter
import com.example.kotlinapplicationdemo.data.QuizRepository
import com.example.kotlinapplicationdemo.databinding.ActivityDisplayAllQuestionsBinding

class DisplayAllQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayAllQuestionsBinding
    private lateinit var adapter: QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayAllQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        QuizRepository.init()
        val questions = QuizRepository.getQuestions()

        adapter = QuestionsAdapter(questions)
        binding.questionsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.questionsRecyclerView.adapter = adapter
    }
}
