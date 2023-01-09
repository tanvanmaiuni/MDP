package com.mdp.quizapp.ui

//import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    private var curIndex = -1


    companion object {
        fun newInstance() = QuizFragment()
        const val MAX_QUESTION = 4
    }

    private lateinit var viewModel: QuizViewModel
    private lateinit var resultViewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)

        curIndex = -1
        getQuestions()

        btnHome.setOnClickListener{
            val directions = QuizFragmentDirections.actionQuizFragmentToWelcomeFragment()
            findNavController().navigate(directions)
        }
        btnNext.setOnClickListener{
            if(curIndex < MAX_QUESTION - 1) {
                recordAnswer()
                nextQuestion()
            }else{
                val directions = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                findNavController().navigate(directions)
            }
        }

        var curQuestion: MutableLiveData<Quiz> = viewModel!!.question

        curQuestion.observe(viewLifecycleOwner, Observer{
            txtQuestion.text = it.question
            radBtnAnsA.text = it.optionA
            radBtnAnsB.text = it.optionB
            radBtnAnsC.text = it.optionC
            radBtnAnsD.text = it.optionD
            radioGroup.clearCheck()
            btnNext.isEnabled = false
        })
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId > -1)
                btnNext.isEnabled = true
        }
    }

    private fun getQuestions() {
        lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                questions = QuizDatabase(it).getQuizDao().getAllQuiz()
                nextQuestion()
            }
        }
    }

    private fun nextQuestion(){
        curIndex += 1
        viewModel!!.setQuestion(questions[curIndex])
    }

    private fun recordAnswer(){
        val checkBtn = radioGroup.checkedRadioButtonId
        if (checkBtn > -1) {
            val radioButton = view?.findViewById<View>(checkBtn) as RadioButton
            println("Selected: ${radioButton.text.toString()}")
            resultViewModel.addAnswer(radioButton.text.toString())
        }

    }

}