package com.example.quizapp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import main.Question

class QuestionViewModel : ViewModel() {

    private var question:Question = loadQuestion()

    private var counter = 0
    private var score = 0
    private var questionsNumber = 10
    private var name = "NO DATA"
    private var highScore = "0"
    private var questionCounterLimit = 10
    private var answerCounterLimit = 40

    fun increaseCounters(){
        questionCounterLimit += 1
        answerCounterLimit += 4
    }

    fun getCounter(): Int {
        return counter
    }

    fun getName() : String{
        return name
    }

    fun setName(newName : String){
        name = newName
    }

    fun reset() {
        counter = 0
        score = 0
    }

    fun getHighScore(): String {
        return highScore
    }

    fun setHighScore(newHighScore: String){
        highScore = newHighScore
    }

    fun getScore(): Int {
        return score
    }

    fun getQuestionsNumber(): String {
        return questionsNumber.toString()
    }

    fun incrementCounter() {
        counter++
    }

    fun incrementScore() {
        score++
    }

    fun getQuestion(): Question {
        Log.d(ContentValues.TAG, "QuestionViewModel: getQuestions()")
        return question
    }

    private var questionCounter : Int = 0
    var answerCounter : Int = 0

    fun loadQuestion() : Question {
        if(questionCounter == questionCounterLimit){
            questionCounter = 0
        }
        if(answerCounter == answerCounterLimit){
            answerCounter = 0
        }
        question = Question(FakeRepository.questions[questionCounter],
        listOf(FakeRepository.answers[answerCounter++],
            FakeRepository.answers[answerCounter++],
            FakeRepository.answers[answerCounter++],
            FakeRepository.answers[answerCounter++]),
        FakeRepository.answers[answerCounter-4])
        Log.d(ContentValues.TAG, "QVM: correct answer: ${FakeRepository.answers[answerCounter-4]}")
        questionCounter++
        return question

    }

}
