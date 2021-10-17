package com.example.quizapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        initializeView()
    }

    private fun initializeView() {
        val userName = intent.getStringExtra(USERNAME_EXTRA)

        val textView = findViewById<TextView>(R.id.say_hello).apply {
            text = "Hello, ${userName}!"
        }
    }
}