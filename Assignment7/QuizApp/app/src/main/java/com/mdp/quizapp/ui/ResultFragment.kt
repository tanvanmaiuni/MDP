package com.mdp.quizapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mdp.quizapp.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    companion object {
        fun newInstance() = ResultFragment()
    }

    private lateinit var viewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val viewModel: ResultViewModel by navGraphViewModels(R.id.quizFragment)
//        val loginBackStackEntry = reme { navController.getBackStackEntry("login") }
//        findNavController().get

        viewModel = ViewModelProvider(requireActivity()).get(ResultViewModel::class.java)
        // TODO: Use the ViewModel
        val correctAns = countCorrectAns(viewModel)
        txtTotalQuestion.text = "Total Question: ${QuizFragment.MAX_QUESTION}"
        txtCorrectAns.text = "Correct Answers(Score): $correctAns"
        txtWrongAns.text = "Wrong Answers:  ${QuizFragment.MAX_QUESTION - correctAns}"
        txtScore.text = "Your score: ${correctAns}/${QuizFragment.MAX_QUESTION}"

        btnTryAgain.setOnClickListener{
            val directions = ResultFragmentDirections.actionResultFragmentToQuizFragment()
            findNavController().navigate(directions)
        }
    }

    fun countCorrectAns(viewModel: ResultViewModel): Int{
        var correctAns = 0
        val questions = viewModel.questions
        val answers = viewModel.answers
        for ((index, question) in questions.withIndex()) {
            val answer = answers[index]
            if(question.answer == answer)
                correctAns += 1
        }
        return correctAns
    }

}