package com.mdp.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val foods: ArrayList<String> = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese ");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDecide.setOnClickListener {
            txtFoodView.text = foods[Random.nextInt(foods.size - 1)]
        }

        btnAddFood.setOnClickListener{
            txtFoodView.text = txtNewFood.text;
        }
    }
}