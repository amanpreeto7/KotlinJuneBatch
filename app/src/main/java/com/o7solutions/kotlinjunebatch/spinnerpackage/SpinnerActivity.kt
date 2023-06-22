package com.o7solutions.kotlinjunebatch.spinnerpackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.o7solutions.kotlinjunebatch.R
import com.o7solutions.kotlinjunebatch.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    var array = arrayOf("Raman","Surbhi", "Lovejeet")
    var arrayList = arrayListOf<String>("Raman")
    var spinnerStaticArrayList = arrayListOf<String>()
    var spinnerDynamicArrayList = arrayListOf<String>()

    //Adapter
    lateinit var arrayAdapter : ArrayAdapter<String>

    lateinit var binding: ActivitySpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayList.add("Gaurav")
        arrayList.add("Aaksh")
//        arrayList.clear()
        arrayList.removeIf { element-> element == "Surbhi" }
        var index = arrayList.indexOfFirst { element-> element == "Surbhi" }

        //will lead to crash for spinner
//        binding.staticSpinner.setOnItemClickListener { parent, view, position, id ->
//            System.out.println("On item click $position")
//        }

        spinnerStaticArrayList.addAll(resources.getStringArray(R.array.gender_array))
        binding.staticSpinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                System.out.println("position $position ${spinnerStaticArrayList.get(position)}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //populating array
        spinnerDynamicArrayList.add("Raman")
        spinnerDynamicArrayList.add("Surbhi")
        spinnerDynamicArrayList.add("Lovejeet")
        spinnerDynamicArrayList.add("Satnam")
        //dynamic adapter code starts
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinnerDynamicArrayList)
        //dynamic adapter code ends
        binding.dynamicSpinner.adapter = arrayAdapter
    }
}