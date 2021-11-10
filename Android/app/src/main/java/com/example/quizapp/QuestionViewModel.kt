package com.example.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.Question

class QuestionViewModel : ViewModel() {

    private lateinit var question : Question
    private var questions = MutableLiveData<ArrayList<Question>>()

    private var counter = 0
    private var score = 0
    private var questionsNumber = 5
    private var name = "NO DATA"
    private var highScore = "0"
    private var questionCounterLimit = 10
    private var answerCounterLimit = 40
    private val loading = MutableLiveData<Boolean>()

    fun isLoading(): Boolean {
        return loading.value!!
    }

    fun addQuestion(question: Question) {
        questions.value?.add(question)
    }

    fun getAllQuestions(): LiveData<ArrayList<Question>> {
        return questions
    }

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
        return question
    }

    private var questionCounter : Int = 0
    var answerCounter : Int = 0

    fun loadQuestion() : Question {
        question = Question(
            questions.value?.get(questionCounter)?.text.toString(),
        listOf(questions.value?.get(questionCounter)?.answers?.get(0).toString(),
            questions.value?.get(questionCounter)?.answers?.get(1).toString(),
            questions.value?.get(questionCounter)?.answers?.get(2).toString(),
            questions.value?.get(questionCounter)?.answers?.get(3).toString()),
            questions.value?.get(questionCounter)?.answers?.get(0).toString())
        questionCounter++

        if(questionCounter == 9){
            questionCounter = 0
        }

        return question
    }

    fun shuffleQuestions() = questions.value?.shuffle()


    fun loadQuestionList(){
        loading.value = true
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                QuestionRepository.getQuestions()
            }
            if (result.isSuccessful) {
                questions.value = result.body()
                loading.value = false
            }
        }
    }
}
