package com.mdp.quizapp.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.mdp.quizapp.databinding.FragmentResultAnalysisBinding

import com.mdp.quizapp.ui.placeholder.PlaceholderItem.PlaceholderItem
//import com.mdp.quizapp.ui.databinding.FragmentResultAnalysisBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyResultAnalysisItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyResultAnalysisItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentResultAnalysisBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.question.text = item.question
        holder.yourAns.text =  "Your Ans: " + item.answer
        holder.correctAns.text = "Correct Ans: " + item.correctAnswer
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentResultAnalysisBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val question: TextView = binding.txtQuestionAnalysis
        val yourAns: TextView = binding.txtYourAns
        val correctAns: TextView = binding.txtCorrectAnsAnalysis


        override fun toString(): String {
            return super.toString() + " '" + question.text + "'"
        }
    }

}