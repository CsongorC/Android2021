package main

import java.io.File

class QuizController {

    val questions = arrayListOf<Question>()

    init {
        val lines = File("questions.txt").readLines()
        var i : Int = 0
        while (i != lines.size){
            questions.add(Question(lines[i], listOf(lines[i+1], lines[i+2], lines[i+3], lines[i+4])))
            i += 5
        }
    }

    fun doQuiz(numberOfQuestions : Int){

        randomizeQuestions()

        var yourAnswer : String
        var yourScore : Int = 0
        var iter : Int = 0

        while(numberOfQuestions!= iter){

            val correctAnswer : String = questions[iter].answers[0]

            println("Question: " + questions[iter].text)
            var quizAnswers = questions[iter].answers.shuffled()
            println("1. " + quizAnswers[0])
            println("2. " + quizAnswers[1])
            println("3. " + quizAnswers[2])
            println("4. " + quizAnswers[3])

            println("Your answer (1/2/3/4): ")
            yourAnswer = readLine().toString()

            if(correctAnswer == quizAnswers[yourAnswer.toInt()-1]){
                yourScore++
            }

            iter++
            println()
        }

        println("Your final score: $numberOfQuestions/$yourScore" )
    }

    fun randomizeQuestions(){
        questions.shuffle()
    }
}