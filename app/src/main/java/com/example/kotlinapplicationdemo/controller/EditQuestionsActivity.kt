package com.example.kotlinapplicationdemo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapplicationdemo.AddQuestionActivity
import com.example.kotlinapplicationdemo.data.QuizRepository
import com.example.kotlinapplicationdemo.databinding.ActivityEditQuestionBinding
import com.example.kotlinapplicationdemo.model.Question

class EditQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditQuestionBinding
    private var selectedIndex: Int = -1 // Track which question is selected

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Populate spinner with question titles
        updateSpinner()

        binding.questionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (QuizRepository.questionList.isNotEmpty()) {
                    selectedIndex = position
                    val selectedQuestion = QuizRepository.questionList[position]

                    // Fill fields with existing data
                    binding.questionInput.setText(selectedQuestion.question)
                    binding.optionAInput.setText(selectedQuestion.options[0])
                    binding.optionBInput.setText(selectedQuestion.options[1])
                    binding.optionCInput.setText(selectedQuestion.options[2])
                    binding.optionDInput.setText(selectedQuestion.options[3])
                    binding.correctAnswerInput.setText(selectedQuestion.correctAnswer)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedIndex = -1
            }
        }

        binding.updateBtn.setOnClickListener {
            if (selectedIndex == -1) {
                Toast.makeText(this, "Please select a question", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedQuestion = binding.questionInput.text.toString().trim()
            val updatedA = binding.optionAInput.text.toString().trim()
            val updatedB = binding.optionBInput.text.toString().trim()
            val updatedC = binding.optionCInput.text.toString().trim()
            val updatedD = binding.optionDInput.text.toString().trim()
            val updatedCorrect = binding.correctAnswerInput.text.toString().trim()

            if (updatedQuestion.isEmpty() || updatedA.isEmpty() || updatedB.isEmpty() ||
                updatedC.isEmpty() || updatedD.isEmpty() || updatedCorrect.isEmpty()
            ) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Replace the question in the list with a new Question object
            val updatedQuestionObj = Question(
                question = updatedQuestion,
                options = listOf(updatedA, updatedB, updatedC, updatedD),
                correctAnswer = updatedCorrect
            )

            QuizRepository.questionList[selectedIndex] = updatedQuestionObj

            Toast.makeText(this, "Question updated!", Toast.LENGTH_SHORT).show()
            updateSpinner()
        }
    }

    private fun updateSpinner() {
        val titles = QuizRepository.questionList.mapIndexed { index, q ->
            "Q${index + 1}: ${q.question.take(25)}"
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, titles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.questionSpinner.adapter = adapter
    }
}
