package com.mdp.quizapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdp.quizapp.db.Quiz

class QuizViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var question = MutableLiveData<Quiz>()

    fun setQuestion(quiz: Quiz){
        question.value = quiz
    }
}