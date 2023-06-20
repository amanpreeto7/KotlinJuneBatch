package com.o7solutions.kotlinjunebatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.o7solutions.kotlinjunebatch.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var activityInterface: ActivityInterface
    lateinit var binding : ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvActivity.setOnClickListener {
            activityInterface.CalledFromFragment()
        }
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, " on stop", Toast.LENGTH_LONG).show()
    }


    fun changeText(){
        binding.tvText.setText("Changed from fragment")

    }
}