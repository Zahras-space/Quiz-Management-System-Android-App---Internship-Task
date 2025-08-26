package com.example.kotlinapplicationdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.data.QuizRepository
import com.example.kotlinapplicationdemo.databinding.ActivityAddQuestionsBinding
import com.example.kotlinapplicationdemo.model.Question

class AddQuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val questionText = binding.questionInput.text.toString().trim()
            val optionA = binding.optionAInput.text.toString().trim()
            val optionB = binding.optionBInput.text.toString().trim()
            val optionC = binding.optionCInput.text.toString().trim()
            val optionD = binding.optionDInput.text.toString().trim()
            val correctAnswer = binding.correctAnswerInput.text.toString().trim().uppercase() // expects "A"/"B"/"C"/"D"

            if (questionText.isEmpty() || optionA.isEmpty() || optionB.isEmpty() ||
                optionC.isEmpty() || optionD.isEmpty() || correctAnswer.isEmpty()
            ) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (correctAnswer !in listOf("A", "B", "C", "D")) {
                Toast.makeText(this, "Correct answer must be A, B, C, or D", Toast.LENGTH_SHORT).show()
            } else {
                // Wrap options in a List
                val options = listOf(optionA, optionB, optionC, optionD)
                val question = Question(questionText, options, correctAnswer)

                // ✅ Add directly to repository
                QuizRepository.questionList.add(question)

                Toast.makeText(this, "Question Added Successfully!", Toast.LENGTH_SHORT).show()

                // Clear inputs
                binding.questionInput.text?.clear()
                binding.optionAInput.text?.clear()
                binding.optionBInput.text?.clear()
                binding.optionCInput.text?.clear()
                binding.optionDInput.text?.clear()
                binding.correctAnswerInput.text?.clear()
            }
        }
    }
}
