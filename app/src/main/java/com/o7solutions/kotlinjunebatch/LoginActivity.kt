package com.o7solutions.kotlinjunebatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.error = "Enter your email"
            }else if(etPassword.text.toString().isNullOrEmpty()){
                etPassword.error = resources.getString(R.string.enter_password)
            }else {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
}