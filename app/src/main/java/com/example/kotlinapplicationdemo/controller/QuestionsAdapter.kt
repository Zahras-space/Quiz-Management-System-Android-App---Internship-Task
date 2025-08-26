package com.example.kotlinapplicationdemo.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplicationdemo.databinding.ItemQuestionsBinding
import com.example.kotlinapplicationdemo.model.Question

class QuestionsAdapter(private val questions: List<Question>) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(val binding: ItemQuestionsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = ItemQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]

        // Set question text
        holder.binding.questionText.text = "${position + 1}. ${question.question}"

        // Safely access the options list
        val optionA = question.options.getOrNull(0) ?: ""
        val optionB = question.options.getOrNull(1) ?: ""
        val optionC = question.options.getOrNull(2) ?: ""
        val optionD = question.options.getOrNull(3) ?: ""

        // Display options
        holder.binding.optionsText.text ="A) $optionA\n" + "B) $optionB\n" + "C) $optionC\n" + "D) $optionD"

        // Display correct answer (e.g. "A", "B", "C", or "D")
        holder.binding.answerText.text = "Answer: ${question.correctAnswer}"
    }

    override fun getItemCount(): Int = questions.size
}
