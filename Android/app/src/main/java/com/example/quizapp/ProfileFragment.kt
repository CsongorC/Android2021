package com.example.quizapp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
//import kotlinx.android.synthetic.main.fragment_question_add.view.*

class ProfileFragment : Fragment() {

    val viewModel: QuestionViewModel by activityViewModels()
    private lateinit var nameText: TextView
    private lateinit var highScoreText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        if(view != null){
            initializeView(view)
            loadData()
        }

        return view
    }

    private fun loadData(){
        val name = viewModel.getName()
        val score = viewModel.getHighScore()
        Log.d(ContentValues.TAG, "ProfileFragment: $name")
        nameText.text = name
        highScoreText.text = score
    }

    private fun initializeView(view: View){
        Log.d(ContentValues.TAG, "ProfileFragment: initView()")
        nameText = view.findViewById(R.id.playerName)
        highScoreText = view.findViewById(R.id.highScore)
    }


}