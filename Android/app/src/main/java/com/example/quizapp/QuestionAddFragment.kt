package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.quizapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_question_add.*
import kotlinx.android.synthetic.main.fragment_question_add.view.*
import main.Question

class QuestionAddFragment : Fragment() {

    val viewModel: QuestionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question_add, container, false)

        view?.apply {
            registerListeners(this)
        }

        return view
    }

    private fun registerListeners(view: View) {
        view.addQuestionBtn.setOnClickListener {
            if (checkTextViews()) {
                Log.d("CLICK", "Accepted")
                val questionToBeAdded = questionInput.text.toString()
                val answer1OfQuestionToBeAdded = answerInput1.text.toString()
                val answer2OfQuestionToBeAdded = answerInput2.text.toString()
                val answer3OfQuestionToBeAdded = answerInput3.text.toString()
                val answer4OfQuestionToBeAdded = answerInput4.text.toString()

                var questionAdded = Question(questionToBeAdded,
                listOf(answer1OfQuestionToBeAdded,answer2OfQuestionToBeAdded,answer3OfQuestionToBeAdded,answer4OfQuestionToBeAdded),
                    answer1OfQuestionToBeAdded)

                viewModel.addQuestion(questionAdded)

                viewModel.increaseCounters()

                Snackbar.make(requireContext(), it, "Question successfully added", Snackbar.LENGTH_SHORT).show()

                questionInput.text?.clear()
                answerInput1.text?.clear()
                answerInput2.text?.clear()
                answerInput3.text?.clear()
                answerInput4.text?.clear()

            } else {
                Log.d("CLICK", "Rejected")
            }
        }
    }

    private fun checkTextViews(): Boolean {
        var isValid = false
        listOf<EditText>(questionInput,
            answerInput1,
            answerInput2,
            answerInput3,
            answerInput4).forEach {
            if (it.text.toString().trim().isEmpty()) {
                it.error = "This cannot be empty."
                isValid = false
            } else {
                isValid = true
            }
        }
        return isValid
    }
}