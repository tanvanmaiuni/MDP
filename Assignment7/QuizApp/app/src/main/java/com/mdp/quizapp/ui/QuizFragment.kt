package com.mdp.quizapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mdp.quizapp.R
import com.mdp.quizapp.db.Quiz
import com.mdp.quizapp.db.QuizDatabase
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizFragment : Fragment() {
    private lateinit var questions: List<Quiz>

    companion object {
        fun newInstance() = QuizFragment()
    }

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        // TODO: Use the ViewModel

        getQuestions()
        btnHome.setOnClickListener{
            val directions = QuizFragmentDirections.actionQuizFragmentToWelcomeFragment()
            findNavController().navigate(directions)
        }
    }

    private fun getQuestions() {
        lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                questions = QuizDatabase(it).getQuizDao().getAllQuiz()
            }
        }
    }

}