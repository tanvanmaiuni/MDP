package com.mdp.cvbuilderapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdp.cvbuilderapp.model.WorkExperience
import kotlinx.android.synthetic.main.activity_add_work_exp.*
import kotlinx.android.synthetic.main.activity_add_work_exp.txtCompany

class AddWorkExpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work_exp)

        btnAdd.setOnClickListener{
            val newWorkExperience = WorkExperience(
                txtCompany.text.toString(),
                R.drawable.company_general,
                txtTitle.text.toString(),
                txtDuration.text.toString(),
                txtLocation.text.toString()
            )
            intent.putExtra(getString(R.string.key_new_work_experience), newWorkExperience)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}