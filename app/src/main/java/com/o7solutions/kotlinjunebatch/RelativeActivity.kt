package com.o7solutions.kotlinjunebatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class RelativeActivity : AppCompatActivity() {

    lateinit var btnMinus : Button
    lateinit var btnAdd : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var btnSnackbar : Button
    lateinit var tvNumber : TextView
    lateinit var btnAlert : Button
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)

        btnMinus = findViewById(R.id.btnMinus)
        btnAdd = findViewById(R.id.btnAdd)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvNumber = findViewById(R.id.tvNumber)
        btnSnackbar = findViewById(R.id.btnSnackbar)
        btnAlert = findViewById(R.id.btnAlert)

        tvNumber.text = number.toString()

        btnAdd.setOnClickListener {
            number += 2
            tvNumber.text = number.toString()
        }

        btnSnackbar.setOnClickListener {
            var snackbar =
                Snackbar.make(btnSnackbar, "This is snackbar", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAnchorView(R.id.btnSnackbar)
            snackbar.setAction("OK") {
                number += 2
                tvNumber.text = number.toString()
            }
            snackbar.show()
        }

        btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(resources.getString(R.string.title))
                .setMessage("This is testing message")
                .setCancelable(false)
                .setPositiveButton(resources.getString(R.string.positive_button), {_,_->

                })
                .show()
        }
    }
}