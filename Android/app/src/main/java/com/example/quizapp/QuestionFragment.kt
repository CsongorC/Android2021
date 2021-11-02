package com.example.quizapp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentQuestionBinding

import kotlinx.android.synthetic.main.fragment_question.*
import main.Question

class QuestionFragment : Fragment() {

    private lateinit var questionText: TextView
    private lateinit var answerGroup: RadioGroup
    lateinit var question: Question
    private lateinit var correctAnswer: List<CharSequence>

    val viewModel: QuestionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_question,container,
        false)

        if(view != null){
            initializeView(view)
            loadQuestion()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next.setOnClickListener {
            var selectedAnswer =
                listOf<Button>(first, second, third, forth).filter {
                    it.isSelected
                }.map { it.text }

            if (correctAnswer.equals(selectedAnswer)) {
                println("CORRECT ANSWER")
                Log.d(ContentValues.TAG, "QF: Correct answer: $correctAnswer")
                Log.d(ContentValues.TAG, "QF: Selected answer: $selectedAnswer")
                viewModel.incrementScore()
            } else {
                Log.d(ContentValues.TAG, "QF: Correct answer: $correctAnswer")
                Log.d(ContentValues.TAG, "QF: Selected answer: $selectedAnswer")
                println("WRONG ANSWER")
            }

            Log.d(ContentValues.TAG, "QF: Counter: ${viewModel.getCounter()}")

            viewModel.incrementCounter()
            if (viewModel.getCounter() == 9) {
                findNavController().navigate(R.id.action_questionFragment_to_quizEndFragment)
                //viewModel.reset()
            } else {
                findNavController().navigate(R.id.action_questionFragment_self)
            }
        }

        listOf<Button>(first, second, third, forth).forEach {
            it.setOnClickListener { button ->
                button.isSelected = !button.isSelected
            }
        }
    }

    private fun loadQuestion(){
        Log.d(ContentValues.TAG, "QuestionFragment: loadQuestion()")
        question = viewModel.getQuestion()
        correctAnswer = listOf(question.correctAnswer)
        viewModel.loadQuestion()
        questionText.text = question.text
        val answers = arrayListOf<String>()
        answers.addAll(question.answers)
        var i = 0
        answers.shuffled().forEach{
            (answerGroup.getChildAt(i) as RadioButton).text = it; i++
        }
    }

    private fun initializeView(view: View){
        questionText = view.findViewById(R.id.question)
        answerGroup = view.findViewById(R.id.answerOptions)
        Log.d(ContentValues.TAG, "QuestionFragment: initializeView()")
    }
}

