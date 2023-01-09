package com.mdp.quizapp.ui

import androidx.lifecycle.ViewModel
import com.mdp.quizapp.db.Quiz

class ResultViewModel : ViewModel() {
    var questions: List<Quiz>  = ArrayList()
    var answers: MutableList<String> = ArrayList()

    fun addAnswer(ans: String){
        answers.add(ans)
    }
}