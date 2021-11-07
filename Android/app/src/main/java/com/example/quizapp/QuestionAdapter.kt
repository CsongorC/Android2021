package com.example.quizapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import main.Question

class QuestionAdapter(private val questionList : ArrayList<Question>
                      ) : RecyclerView.Adapter<QuestionAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,
        parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = questionList[position]

        holder.QuestionView.text = currentItem.text
        holder.CorrectText.text = currentItem.correctAnswer
        holder.deleteButton.setOnClickListener{deleteItem(position)}
        holder.detailsButton.setOnClickListener{
                view ->
            view.findNavController().navigate(R.id.action_questionListFragment_to_detailsFragment)
        }
    }

    override fun getItemCount() = questionList.size

    inner class ExampleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val QuestionView : TextView = itemView.question
        val CorrectText : TextView = itemView.correct

        val deleteButton : Button = itemView.delete
        val detailsButton : Button = itemView.details
    }

    private fun deleteItem(index: Int){
        questionList.removeAt(index)
        notifyDataSetChanged()
    }

}