package com.mdp.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addRow("Android 9.0", "Pie")
        addRow("Android 8.0", "Oreo")

        btnAdd.setOnClickListener{
            addRow(txtVersion.text.toString(), txtCodeName.text.toString())
        }
    }

    private fun addRow(version: String, codeName: String) {
        // Create a new table row.
        val tableRow = TableRow(this)
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams
        tableRow.gravity = Gravity.CENTER
        tableRow.setBackgroundResource(R.color.black)


        val versionView = TextView(this)
        versionView.width = 200
        versionView.text = version
        versionView.gravity = Gravity.CENTER
        val versionViewParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(1)
        }
        versionView.setBackgroundResource(R.color.table_row)
        versionView.layoutParams = versionViewParam


        val codeNameView = TextView(this)
        val codeNameParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(1)
        }
        codeNameView.layoutParams = codeNameParams
        codeNameView.setBackgroundResource(R.color.table_row)
        codeNameView.width = 200
        codeNameView.gravity = Gravity.CENTER
        codeNameView.text = codeName

        // add values into row by calling addView()
        tableRow.addView(versionView, 0)
        tableRow.addView(codeNameView, 1)
        // Finally add the created row row into layout
        tableVersion.addView(tableRow, layoutParams) // id from Layout_file
    }
}