package com.o7solutions.kotlinjunebatch

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class AlertDialogActivity : AppCompatActivity() {

    lateinit var btnSnackbar : Button
    lateinit var btnAlert : Button
    lateinit var btnCustomAlert : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        btnSnackbar = findViewById(R.id.btnSnackBar)
        btnAlert = findViewById(R.id.btnAlert)
        btnCustomAlert = findViewById(R.id.btnCustomAlert)

        btnSnackbar.setOnClickListener {
            var snackbar =
                Snackbar.make(btnSnackbar, "This is snackbar", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAnchorView(R.id.btnSnackBar)
            snackbar.setAction("OK") {
                Toast.makeText(this, "Snackbar Ok Clicked", Toast.LENGTH_LONG).show()
            }
            snackbar.show()
        }

        btnAlert.setOnClickListener {
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

        btnCustomAlert.setOnClickListener {
           var dialog = Dialog(this@AlertDialogActivity)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            var btnSet = dialog.findViewById<Button>(R.id.btnSet)
            btnSet.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}