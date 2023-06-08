package com.o7solutions.kotlinjunebatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    lateinit var rg : RadioGroup
    lateinit var etValue : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rg = findViewById(R.id.rg)
        etValue = findViewById(R.id.etValue)

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
    }
}