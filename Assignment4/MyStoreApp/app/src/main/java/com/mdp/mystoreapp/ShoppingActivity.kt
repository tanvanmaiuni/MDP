package com.mdp.mystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shoppping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppping)
        val username = intent.getStringExtra("username")
        txtUsername.text = "Welcome $username"
        imgElectronic.setOnClickListener{
            showMsg("Electronic")
        }
        imgClothing.setOnClickListener{
            showMsg("Clothing")
        }
        imgBeauty.setOnClickListener{
            showMsg("Beauty")
        }

        imgFood.setOnClickListener{
            showMsg("Food")
        }
    }

    fun showMsg(type: String){
        Toast.makeText(this, "You have chosen the $type category of shopping", Toast.LENGTH_LONG).show()
    }
}