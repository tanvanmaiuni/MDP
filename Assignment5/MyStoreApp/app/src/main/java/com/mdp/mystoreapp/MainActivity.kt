package com.mdp.mystoreapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mdp.mystoreapp.model.Product
import com.mdp.mystoreapp.model.User
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

        val resultRegister =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val newUser = result.data?.getSerializableExtra("newUser") as User
                    if(newUser != null)
                        listUser.add(newUser)
                }
            }
        btnCreateAccount.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            resultRegister.launch(intent)
        }

        txtForgotPass.setOnClickListener{
            val username = txtUsername.text.toString();
            var foundUser = false
            for(user in listUser){
                if(user.username == username){
                    sendEmail(user.username, user.password)
                    foundUser = true
                }
            }
            if(!foundUser)
                Toast.makeText(this, "Not valid username", Toast.LENGTH_LONG).show()
        }
    }

    private fun sendEmail(email: String, content: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your password");
        intent.putExtra(Intent.EXTRA_TEXT, content)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
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