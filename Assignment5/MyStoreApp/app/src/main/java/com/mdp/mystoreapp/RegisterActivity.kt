package com.mdp.mystoreapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.btnCreateAccount
import kotlinx.android.synthetic.main.activity_register.txtPassword

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnCreateAccount.setOnClickListener{
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            val newUser = User(txtFirstName.text.toString(), txtLastName.text.toString(), txtEmail.text.toString(), txtPassword.text.toString())
            val rintent = intent
            rintent.putExtra("newUser", newUser)
            setResult(Activity.RESULT_OK, rintent)
            finish()
        }
    }
}