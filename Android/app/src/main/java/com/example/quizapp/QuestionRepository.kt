package com.example.quizapp

import android.util.Log
import main.Question
import retrofit2.Response

object QuestionRepository {
    suspend fun getQuestions(): Response<ArrayList<Question>> {
        val request = ServiceBuilder.buildService(QuestionEndpoints::class.java)
        Log.i("QuizViewModel", "Started loading the questions")
        return request.loadQuestionList()
    }
}