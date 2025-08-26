package com.example.kotlinapplicationdemo.data

import com.example.kotlinapplicationdemo.model.Question

object QuizRepository {
    val questionList = mutableListOf<Question>()


    fun init() {
        if (questionList.isEmpty()) questionList.addAll(loadQuestions())
    }

    fun getQuestions(): List<Question> = questionList.toList()
    fun getQuestion(index: Int): Question = questionList[index]
    fun size(): Int = questionList.size

    fun addQuestion(q: Question) { questionList.add(q) }

    fun updateQuestion(index: Int, q: Question) {
        if (index in questionList.indices) questionList[index] = q
    }

    fun deleteQuestion(index: Int) {
        if (index in questionList.indices) questionList.removeAt(index)
    }

    private fun loadQuestions(): List<Question> {
        val questionList = listOf(
            mapOf(
                "question" to "Which keyword is used to declare a variable in Kotlin?",
                "options" to listOf("var", "val", "let", "const"),
                "answer" to "A"
            ),
            mapOf(
                "question" to "Which function is the entry point of a Kotlin program?",
                "options" to listOf("start()", "run()", "main()", "init()"),
                "answer" to "C"
            ),
            mapOf(
                "question" to "Which of these is NOT a Kotlin data type?",
                "options" to listOf("Int", "String", "Boolean", "Character"),
                "answer" to "D"
            ),
            mapOf(
                "question" to "What does JVM stand for?",
                "options" to listOf(
                    "Java Virtual Machine",
                    "Java Visual Model",
                    "Joint Virtual Module",
                    "Java Variable Memory"
                ),
                "answer" to "D" // kept same as your console code
            )
        )
        return questionList.map { q ->
            Question(
                q["question"] as String,
                q["options"] as List<String>,
                q["answer"] as String
            )
        }
    }
}