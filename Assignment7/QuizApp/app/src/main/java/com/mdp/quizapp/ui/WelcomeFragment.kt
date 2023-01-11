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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDB()
        btnStart.setOnClickListener {
            val directions = WelcomeFragmentDirections.actionWelcomeFragmentToQuizFragment()
            findNavController().navigate(directions)
        }
    }

    private fun initDB() {
        val quiz1 = Quiz(
            1,
            "1. Kotlin is developed by?",
            "JetBrains",
            "Google",
            "Adobe",
            "Microsoft",
            "JetBrains"
        )
        val quiz2 = Quiz(
            2,
            "2. Kotlin is a statically-typed programming language which runs on the?",
            "JCM",
            "JVM",
            "JPM",
            "JDM",
            "JVM"
        )

        val quiz3 = Quiz(
            3,
            "3. Why you should switch to Kotlin from Java?",
            "Kotlin language is quite simple compared to Java",
            "It reduces may redundancies in code as compared to Java",
            "Kotlin can offer some useful features which are not supported by Java",
            "All of the above",
            "All of the above"
        )
        val quiz4 = Quiz(
            4,
            "4. ____________ feature allows removing the risk of occurrence of " +
                    "NullPointerException in real time.",
            "Null Risk",
            "Null Safety",
            "Null Pointer",
            "All of the above",
            "Null Safety"
        )

        val quiz5 = Quiz(
            5,
            "5. Kotlin is interoperable with Java because it uses JVM bytecode",
            "Yes",
            "No",
            "Can be yes or no",
            "Can not say",
            "Yes"
        )

        val quiz6 = Quiz(
            6,
            "6. How can you declare a variable in Kotlin?",
            "value my_var: Char",
            "value Char : my_var",
            "my_var: Char",
            "value my_var: Char",
            "value my_var: Char"

        )
        val quiz7 = Quiz(
            7, "7. How many types of constructors available in Kotlin?",
            "1", "2", "3", "4", "2"
        )
        val quiz8 = Quiz(
            8,
            "8. Which of the following is Use for reading contents of file to ByteArray?",
            "bufferedReader()",
            "readText()",
            "readBytes()",
            "readLines()",
            "readBytes()"
        )
        val quiz9 = Quiz(
            9,
            "9. What is the use of data class in Kotlin?",
            "extract the basic data types",
            "delete the basic data types",
            "present the basic data types",
            "holds the basic data types",
            "holds the basic data types"

        )
        val quiz10 = Quiz(
            10,
            "10. Is there any Ternary Conditional Operator in Kotlin like in Java?",
            "TRUE",
            "FALSE",
            "Can be true or false",
            "Can not say",
            "FALSE"
        )
        val quiz11 = Quiz(
            11,
            "11. In Kotlin, ____________ is used when you know what functionalities a class should have.",
            "exception class",
            "inheritance class",
            "abstraction class",
            "None of the above",
            "abstraction class"

        )
        val quiz12 = Quiz(
            12,
            "12. What is the syntax for declaring a variable as volatile in Kotlin?",
            "var x: Long? = null",
            "Volatile var x: Long?",
            "Volatile var x",
            "Volatile var x: Long? = null",
            "Volatile var x: Long? = null"
        )
        val quiz13 = Quiz(
            13,
            "13. Which of th following is used to compare two strings in Kotlin?",
            "Using == operator",
            "Using compareTo() extension function",
            "Both A and B",
            "None of the above",
            "Both A and B"
        )
        val quiz14 = Quiz(
            14,
            "14. Elvis Operator is used for handling null expectations in Kotlin.",
            "TRUE",
            "FALSE",
            "Can be true or false",
            "Can not say",
            "TRUE"
        )
        val quiz15 = Quiz(
            15,
            "15. ____________ helps to iterate through a range.",
            "And operator",
            "Ranges operator",
            "Or operator",
            "Conditional operator",
            "Ranges operator"
        )

        lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                println("Init DB")
                QuizDatabase(it).getQuizDao().deleteAllQuiz()
                QuizDatabase(it).getQuizDao().addQuiz(quiz1)
                QuizDatabase(it).getQuizDao().addQuiz(quiz2)
                QuizDatabase(it).getQuizDao().addQuiz(quiz3)
                QuizDatabase(it).getQuizDao().addQuiz(quiz4)
                QuizDatabase(it).getQuizDao().addQuiz(quiz5)
                QuizDatabase(it).getQuizDao().addQuiz(quiz6)
                QuizDatabase(it).getQuizDao().addQuiz(quiz7)
                QuizDatabase(it).getQuizDao().addQuiz(quiz8)
                QuizDatabase(it).getQuizDao().addQuiz(quiz9)
                QuizDatabase(it).getQuizDao().addQuiz(quiz10)
                QuizDatabase(it).getQuizDao().addQuiz(quiz11)
                QuizDatabase(it).getQuizDao().addQuiz(quiz12)
                QuizDatabase(it).getQuizDao().addQuiz(quiz13)
                QuizDatabase(it).getQuizDao().addQuiz(quiz14)
                QuizDatabase(it).getQuizDao().addQuiz(quiz15)
            }
        }
    }

}