package com.example.kotlinapplicationdemo.model

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: String // expects "A"/"B"/"C"/"D"
)
