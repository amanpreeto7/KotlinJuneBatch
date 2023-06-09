package com.o7solutions.kotlinjunebatch

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var llRegister : LinearLayout
    lateinit var toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        toolbar = findViewById(R.id.toolbar)
        llRegister = findViewById(R.id.llRegister)
        setSupportActionBar(toolbar)
        btnLogin.setOnClickListener{
            if(etEmail.text.toString().isNullOrEmpty()){
                etEmail.error = "Enter your email"
            }else if(etPassword.text.toString().isNullOrEmpty()){
                etPassword.error = resources.getString(R.string.enter_password)
            }else {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                var email = etEmail.text.toString()
                var password = etPassword.text.toString()
                System.out.println("Email $email password $password")
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                startActivity(intent)
                finish()
            }
        }

        llRegister.setOnClickListener{
            Snackbar.make(llRegister, "This is snackbar", Snackbar.LENGTH_LONG).show()
        }
    }
}