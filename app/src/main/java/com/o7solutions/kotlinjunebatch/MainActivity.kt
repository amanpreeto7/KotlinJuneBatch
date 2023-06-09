package com.o7solutions.kotlinjunebatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainActivity : AppCompatActivity() {
    lateinit var rg : RadioGroup
    lateinit var etValue : EditText
    lateinit var checkbox : CheckBox
    lateinit var rbFirst : RadioButton
    lateinit var et1 : EditText
    lateinit var et2 : EditText
    lateinit var et3 : EditText
    lateinit var et4 : EditText
    var email = ""
    var password = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent?.extras?.let {
            email = it.getString("email", "")
            password = it.getString("password", "")
            System.out.println("email in main $email password $password")
        }

        //finding views by ids
        rg = findViewById(R.id.rg)
        etValue = findViewById(R.id.etValue)
        checkbox = findViewById(R.id.checkbox)
        rbFirst = findViewById(R.id.rbFirst)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        et3 = findViewById(R.id.et3)
        et4 = findViewById(R.id.et4)
        //change the action bar title
        supportActionBar?.title = email

        //setting checked change listener on radio group
        rg.setOnCheckedChangeListener { group, checkedId ->
            System.out.println("CheckedId $checkedId")
            when(checkedId){
                R.id.rbFirst ->{ System.out.println("First Selected")
                    etValue.visibility = View.VISIBLE
                }
                R.id.rbSecond ->{ System.out.println("Second Selected")
                etValue.visibility = View.GONE
                }
            }
        }
       // checkbox.isChecked
       // rbFirst.isChecked
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this,
                    resources.getString(R.string.check_box_checked),
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,
                    resources.getString(R.string.check_box_unchecked),
                    Toast.LENGTH_LONG).show()
            }
        }

        //moving to next edittext
        et1.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) > 0){
                et2.requestFocus()
            }
        }
        et2.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) > 0){
                et3.requestFocus()
            }
        }
        et3.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) > 0){
                et4.requestFocus()
            }
        }


    }
}