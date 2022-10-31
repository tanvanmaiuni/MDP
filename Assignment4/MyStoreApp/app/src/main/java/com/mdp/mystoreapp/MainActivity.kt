package com.mdp.mystoreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txtUsername
import kotlinx.android.synthetic.main.shoppping_activity.*

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
        btnSignIn.setOnClickListener{
            if(login(txtUsername.text.toString(), txtPassword.text.toString())){
                Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ShoppingActivity::class.java)
                intent.putExtra("username", txtUsername.text.toString())
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