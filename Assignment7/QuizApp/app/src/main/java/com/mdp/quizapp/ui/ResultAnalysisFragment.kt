package com.mdp.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mdp.quizapp.R
import com.mdp.quizapp.ui.placeholder.PlaceholderItem

/**
 * A fragment representing a list of Items.
 */
class ResultAnalysisFragment : Fragment() {

    private var columnCount = 1
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result_analysis_list, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ResultViewModel::class.java)
        buildResultAnalysis(viewModel, PlaceholderItem)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = MyResultAnalysisItemRecyclerViewAdapter(PlaceholderItem.ITEMS)
            }
        }
        return view
    }

    private fun buildResultAnalysis(viewModel: ResultViewModel, placeholderContent: PlaceholderItem) {
        placeholderContent.ITEMS.clear()
        placeholderContent.ITEM_MAP.clear()
        val questions = viewModel.questions
        val answers = viewModel.answers
        for ((index, question) in questions.withIndex()) {
            val answer = answers[index]
            val placeholderItem = PlaceholderItem.PlaceholderItem(index.toString(), question.question, question.answer, answer)
            placeholderContent.addItem(placeholderItem)
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ResultAnalysisFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}