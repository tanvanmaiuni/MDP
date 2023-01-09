package com.mdp.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mdp.quizapp.R
import com.mdp.quizapp.db.Quiz
import com.mdp.quizapp.db.QuizDatabase
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDB()
        btnStart.setOnClickListener{
            val directions = WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment()
            findNavController().navigate(directions)
        }
    }

    private fun initDB() {
        val quiz1 = Quiz(
            1,
            "1) Kotlin is developed by?",
            "JetBrains",
            "Google",
            "Adobe",
            "Microsoft",
            "JetBrains"
        )
        val quiz2 = Quiz(
            2,
            "2) Which of following is used to handle null exceptions in Kotlin?",
            "Elvis Operator",
            "Range",
            "Sealed Class",
            "Lambda function",
            "Elvis Operator"
        )

        lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                println("Init DB")
                QuizDatabase(it).getQuizDao().deleteAllQuiz()
                QuizDatabase(it).getQuizDao().addQuiz(quiz1)
                QuizDatabase(it).getQuizDao().addQuiz(quiz2)
            }
        }
    }

}