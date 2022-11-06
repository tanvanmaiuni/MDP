package com.mdp.quizapp

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listCheckBox: ArrayList<CheckBox> = ArrayList<CheckBox>()
        listCheckBox.add(checkBox1)
        listCheckBox.add(checkBox2)
        listCheckBox.add(checkBox3)
        listCheckBox.add(checkBox4)
        listCheckBox.add(checkBox5)

        btnReset.setOnClickListener {
            radioGroup.clearCheck()
            for (checkBox in listCheckBox) {
                checkBox.isChecked = false
            }
        }

        btnSubmit.setOnClickListener {
            var score = 0
            val checkBtn = radioGroup.checkedRadioButtonId
            if (checkBtn > -1) {
                val radioButton = findViewById<View>(checkBtn) as RadioButton
                val answerQ1 = radioButton.text
                if (answerQ1 == getResources().getString(R.string.answer1_correct))
                    score += 50
            }

            for (checkBox in listCheckBox) {
                if (checkBox.isChecked && getResources().getString(R.string.answer2_correct)
                        .contains(checkBox.text.toString())
                ) {
                    score += 50 / 4
                }
            }
            showResult(score)
        }
    }

    private fun showResult(score: Int) {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Quiz Result")
        builder.setMessage("Congratulations! You submitted on current ${sdf.format(c.time)}, Your achieved $score%”")
        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}