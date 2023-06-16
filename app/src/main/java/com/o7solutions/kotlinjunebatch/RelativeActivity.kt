package com.o7solutions.kotlinjunebatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class RelativeActivity : AppCompatActivity() {

    lateinit var btnMinus : Button
    lateinit var btnAdd : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var tvNumber : TextView
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        btnMinus = findViewById(R.id.btnMinus)
        btnAdd = findViewById(R.id.btnAdd)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvNumber = findViewById(R.id.tvNumber)

        tvNumber.text = number.toString()

        btnAdd.setOnClickListener {
            number += 2
            tvNumber.text = number.toString()
        }
    }
}