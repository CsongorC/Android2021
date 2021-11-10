package com.example.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_question_list.*
import kotlinx.android.synthetic.main.item_layout.*
import main.Question

class QuestionListFragment : Fragment(){
    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout =  inflater.inflate(R.layout.fragment_question_list, container, false)
        Log.d("xxx", "ListFragment - onCreateView")

        viewModel = ViewModelProvider(requireActivity()).get(QuestionViewModel::class.java)
        //val list = getQuestionList()

        viewModel.getAllQuestions().observe(this.viewLifecycleOwner, {
            val adapter = QuestionAdapter(it)
            val recycler_view : RecyclerView = layout.findViewById(R.id.recycler_view)
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(this.context )
            recycler_view.setHasFixedSize(true)
        })

        // connect RecyclerView to the adapter
        //val adapter = QuestionAdapter(list)
        //val recycler_view : RecyclerView = layout.findViewById(R.id.recycler_view)
        //recycler_view.adapter = adapter
        //recycler_view.layoutManager = LinearLayoutManager(this.context )
        //recycler_view.setHasFixedSize(true)

        return layout
    }

    private fun getQuestionList() : ArrayList<Question> {
        val questionList = ArrayList<Question>()
        for(i in 0 until viewModel.getQuestionsNumber().toInt()){
            questionList += viewModel.loadQuestion()
        }
        return questionList
    }
}