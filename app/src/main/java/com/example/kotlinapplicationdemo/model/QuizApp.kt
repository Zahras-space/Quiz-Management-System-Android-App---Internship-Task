package com.example.kotlinapplicationdemo.model
import android.app.Application
import com.example.kotlinapplicationdemo.data.QuizRepository

class QuizApp : Application() {
    override fun onCreate() {
        super.onCreate()
        QuizRepository.init()
    }
}