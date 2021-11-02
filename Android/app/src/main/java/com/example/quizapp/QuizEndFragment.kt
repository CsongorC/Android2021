package com.example.quizapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_question.*
import kotlinx.android.synthetic.main.fragment_quiz_end.*


class QuizEndFragment : Fragment() {

    private lateinit var resultTextView: TextView
    val viewModel: QuestionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_quiz_end,container,
            false)

        if(view != null){
            initializeView(view)
            loadResult()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_tryagain.setOnClickListener {
            if(viewModel.getScore() > viewModel.getHighScore().toInt()){
                viewModel.setHighScore(viewModel.getScore().toString())
            }
            viewModel.reset()
            val action = QuizEndFragmentDirections.actionQuizEndFragmentToQuizStartFragment()
            findNavController().navigate(action)
        }
    }

    private fun loadResult(){
        resultTextView.text = viewModel.getScore().toString()
        val number = viewModel.getQuestionsNumber()
        resultTextView.append("/$number")
    }

    private fun initializeView(view: View){
        resultTextView= view.findViewById(R.id.result)
        Log.d(ContentValues.TAG, "QuizEndFragment: initializeView()")
    }
}