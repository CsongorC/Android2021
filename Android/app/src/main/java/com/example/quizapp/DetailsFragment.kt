package com.example.quizapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_question.*
import main.Question

class DetailsFragment : Fragment() {

    private lateinit var questionText: TextView
    private lateinit var firstText: TextView
    private lateinit var secondText: TextView
    private lateinit var thirdText: TextView
    private lateinit var forthText: TextView
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
        val view = inflater.inflate(R.layout.fragment_details,container,
            false)

        if(view != null){
            initializeView(view)
            loadDetails()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadDetails(){
        questionText.text = FakeRepository.questionDetail.text
        firstText.text = FakeRepository.questionDetail.answers[0]
        secondText.text = FakeRepository.questionDetail.answers[1]
        thirdText.text = FakeRepository.questionDetail.answers[2]
        forthText.text = FakeRepository.questionDetail.answers[3]
    }

    private fun initializeView(view: View) {
        questionText = view.findViewById(R.id.question)
        firstText = view.findViewById(R.id.first)
        secondText = view.findViewById(R.id.second)
        thirdText = view.findViewById(R.id.third)
        forthText = view.findViewById(R.id.forth)
    }
}