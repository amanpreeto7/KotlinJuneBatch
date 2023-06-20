package com.o7solutions.kotlinjunebatch

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.o7solutions.kotlinjunebatch.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {

    lateinit var binding : ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSnackBar.setOnClickListener {
            var snackbar =
                Snackbar.make(binding.btnSnackBar, "This is snackbar", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAnchorView(R.id.btnSnackBar)
            snackbar.setAction("OK") {
                Toast.makeText(this, "Snackbar Ok Clicked", Toast.LENGTH_LONG).show()
            }
            snackbar.show()
        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Title")
                .setPositiveButton("Positive"){_,_->
                    Toast.makeText(this, "This is Positive Button", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Negative"){_,_->
                    Toast.makeText(this, "This is Negative Button", Toast.LENGTH_LONG).show()
                }
                .setNeutralButton("Neutral"){_,_->
                    Toast.makeText(this, "This is Neutral Button", Toast.LENGTH_LONG).show()
                }
                .show()
        }

        binding.btnCustomAlert.setOnClickListener {
           var dialog = Dialog(this@AlertDialogActivity)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            var btnSet = dialog.findViewById<Button>(R.id.btnSet)
            var etName = dialog.findViewById<EditText>(R.id.etName)
            etName.setText(binding.tvName.text)
            btnSet.setOnClickListener {
                if(etName.text.toString().isNullOrBlank()){
                    etName.error = "Enter name"
                }else{
                    binding.tvName.text = etName.text.toString()
                    dialog.dismiss()
                    val phone = "+9417846155"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
                    startActivity(intent)

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}