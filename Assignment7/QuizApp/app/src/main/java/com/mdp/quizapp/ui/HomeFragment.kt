package com.mdp.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mdp.quizapp.R
import com.mdp.quizapp.db.Quiz
import com.mdp.quizapp.db.QuizDatabase
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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

        launch {
            context?.let {
                QuizDatabase(it).getQuizDao().deleteAllQuiz()
                QuizDatabase(it).getQuizDao().addQuiz(quiz1)
                QuizDatabase(it).getQuizDao().addQuiz(quiz2)
            }
        }
    }

}