package com.mdp.cvbuilderapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdp.cvbuilderapp.model.WorkExperience
import kotlinx.android.synthetic.main.fragment_work.*

/**
 * A simple [Fragment] subclass.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment() {
    var workList = mutableListOf<WorkExperience>()

    private fun initList(){
        workList = mutableListOf(
            WorkExperience(
                "Google",
                R.drawable.company_gg,
                "Senior Software Engineer",
                "Feb 2018 - Now",
                "CA, USA"
            ),
            WorkExperience(
                "Nvidia",
                R.drawable.company_nvidia,
                "Software Engineer",
                "Nov 2016 - Jan 2018",
                "CA, USA"
            ),
            WorkExperience(
                "Microsoft",
                R.drawable.company_ms,
                "Software Engineer",
                "Apr 2014 - Nov 2016",
                "WA, USA"
            )
        )
    }

    private fun buildRecycleView(){
        listWorkExpRecycleView.layoutManager = LinearLayoutManager(context)
        listWorkExpRecycleView.adapter = WorkExperienceAdapter(requireContext(), workList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initList()
        buildRecycleView()
        val resultRegister =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val newWorkExperience = result.data?.getSerializableExtra(getString(R.string.key_new_work_experience))
                            as WorkExperience
                    if(newWorkExperience != null){
                        workList.add(newWorkExperience)
                        buildRecycleView()
                    }
                }
            }

        btnAddWorkExp.setOnClickListener{
            val intent = Intent(requireContext(), AddWorkExpActivity::class.java)
            resultRegister.launch(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        btnCreateAccount.setOnClickListener{
//            val intent = Intent(this, RegisterActivity::class.java)
//            resultRegister.launch(intent)
//        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

}