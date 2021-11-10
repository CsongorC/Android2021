package com.example.quizapp

import main.Question
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuestionEndpoints {
    @GET("617a6387aa02be1d445fee92")
    @Headers("X-Bin-Meta: false", "X-Master-key: " + Constants.API_KEY)
    suspend fun loadQuestionList(): Response<ArrayList<Question>>
}