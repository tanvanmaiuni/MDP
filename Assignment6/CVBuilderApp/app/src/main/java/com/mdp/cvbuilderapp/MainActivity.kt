package com.mdp.cvbuilderapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mdp.cvbuilderapp.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val listUser = arrayListOf(
        User("John", "Nathan", "user1@gmail.com", "123456"),
        User("Hana", "Tran", "user2@gmail.com", "123456"),
        User("Jim", "Nguyen", "user3@gmail.com", "123456"),
        User("Ka", "Nathan", "user4@gmail.com", "123456"),
        User("Jack", "Mai", "user5@gmail.com", "123456")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spf = getSharedPreferences("login", Context.MODE_PRIVATE)
        val email = spf.getString("email", "")
        val pwd = spf.getString("pass", "")

        txtEmail.setText(email)
        txtPassword.setText(pwd)

        btnLogin.setOnClickListener{
            //TODO check login
            if(login(txtEmail.text.toString(), txtPassword.text.toString())){
                val spe = spf.edit()
                spe.putString("email", txtEmail.text.toString())
                spe.putString("pass", txtPassword.text.toString())
                spe.apply()

                Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Login fail", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun login(username: String, password: String): Boolean {
        for(user in listUser){
            if(user.username == username && user.password == password)
                return true
        }
        return false
    }
}